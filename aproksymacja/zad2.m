clear all;
close all;
format;
clc;

%% porównanie metod dla różnych długości sygnału wejściowego

compare_FIR_YW(50,1);

compare_FIR_YW(100,2);

compare_FIR_YW(200,3);

compare_FIR_YW(1000,4);


%% funkcja porównująca obie metody

function [] = compare_FIR_YW(leng, num)

    %% wczytanie danych do zmiennych

    load sndb_prbs;

    M=30; % długość licznika
    L=leng; % długość sygnału wejściowego
    
    %% metoda parametryczna model FIR o długości M
    
    y = y + 0.1*randn(size(y)) ; % dodaj szum
    
    U=[]; 
    for i=1:M
        U=[U, u(M-i+1:L-i+1)];
    end
    
    Y=y(M:L);
    b=U\Y;
    Hls=freqz(b(1:M),1, round(L/2));
    ids=1:L/2;
    Freqs=(ids-1)*fs/L;
    
    figure(num);
    hold on;
    plot_title = strcat("L = ", num2str(L)); % utwórz tytuł wykresu
    title(plot_title);
    plot(Freqs' , 20*log10(abs(Hls(1:end))), 'r-');

    
    %% metoda podana w instrukcji z równaniem Yule'a-Walkera
    
    y = y(1:L); % długości u wejściowego i zaszumionego muszą byc takie same
    cor = xcorr(y,u); % dokonaj korelacja ze wzoru z instrukcji
    cor = cor(1:L);% dopasuj długość do  y

    H = fft(cor);% zakładamy ze fft(xcor(u,u))=1 
    H = (H.*conj(H)).^0.5/length(H); % conj - tworzy sprzężenie | % oblicz wartosci rzeczywiste
                                                                                           
    H = H(1:end/2+1); % potrzebujemy tylko pierwszej części filtru,
    H(2:end-1) = 2*H(2:end-1); % podwajamy wartości
    
    figure(num);
    hold on;
    plot(Freqs',20*log10(abs(H(1:end-1))),'g-');
end




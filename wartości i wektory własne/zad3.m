clear all;
close all;
format;
clc;

X=double(imread('lena512.bmp')); % wczytaj dane do zmiennej X

%% bezstratna kompresja obrazu

[U,S,V] = svd(X); % dekompozycja SVD macierzy X

Xsvd = U*S*V'; % odtwórz obraz ze składowych dekompozycji

figure(512)
imagesc(Xsvd); % wyświtl złożony na nowo obraz


%% kompresja obrazów z wykorzystaniem odpowiedniej liczby wartości osobliwych

s = [250; 50; 25; 10; 5; 1]; % liczba wartości osobliwych, które wykorzystamy
diagonal = diag(S);

for i=1:size(s)
    Sn = zeros(size(S));
    Un = zeros(size(S));
    Vn = zeros(size(S));
    
    for j=1:s(i) % wykorzystaj odpowiednią ilość wartości osobliwych
        % macierz S jest diagonalna więc zmieniamy tylko elementy diagonalne 
        Sn(j,j) = diagonal(j); 
        Un(:,j) = U(:,j); % wystarczy zapisać s kolumn
        Vn(:,j) = V(:,j); % wystarczy zapisać s kolumn
    end
    
    lena = Un*Sn*Vn';
    figure(s(i));
    imagesc(lena)
    
    PSNR_calculated(i) = calculate_PSNR(lena, X);
    % PSNR_matlab(i) = measerr(lena, X);
end

% oblicz różnicę PSNR między implementowanym algorytmem
% a algorytmem matlaba
% diff = abs(PSNR_calculated - PSNR_matlab); 


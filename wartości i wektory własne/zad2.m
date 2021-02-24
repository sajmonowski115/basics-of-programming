clear all;
close all;
format;
clc;

%% wczytanie danych do zmiennych
% mix- dane, Fs- częstotliwość próbkowania (16000 Hz)
[mix1, Fs1] = audioread('mix1.wav');
[mix2, Fs2] = audioread('mix2.wav');


%% obliczenia
A = cov(mix1, mix2); % zbuduj macierz kowariancji

% P- macierz wektorów własnych, 
% D- macierz, która na diagonalnej ma wartości własne macierzy A
[P,D] = eig(A); % znajdź wektory własne macierzy

result = (P' * [mix1, mix2]')'; % dekorelacja sygnałów mix1, mix2 macierzą P

%% utworzenie plików dźwiękowych
audiowrite('speech.wav', result(:,1), Fs2);
audiowrite('music.wav', result(:,2), Fs2);

figure(1);
subplot(3,2,1);
title("Przed dekorelacja - mix1");
hold on;
plot(mix1);

subplot(3,2,2);
title("Przed dekorelacja - mix2");
hold on;
plot(mix2);

subplot(3,2,3);
hold on;
title("Po dekorelacji mowa");
plot(result(:,1));

subplot(3,2,4);
hold on;
title("Po dekorelacji dźwięk");
plot(result(:,2));

subplot(3,2,5);
hold on;
title("plot");
plot(mix1, mix2);
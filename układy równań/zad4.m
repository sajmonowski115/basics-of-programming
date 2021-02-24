clear all;
close all;
format;
clc;

% podpunkt 1
[x, fpr] = audioread('A.wav');
figure(1)
plot(x);
soundsc(x, fpr);

% podpunkt 2
rk=xcorr(x); % dokonaj autokorelacji sygnału
r128 = rk(1:128);
[max_value, T] = max(r128);
figure(2)
plot(r128);
fprintf("maksymalna wartość: "); disp(max_value);
fprintf("indeks maksymalnej wartości: "); disp(T);

% podpunkt 3
P = 10;
R = zeros(P, P);
r = zeros(P, 1);

for i=0:P-1 % generuj macierz R
    for j=0:P-1
        R(i+1, j+1)=rk(mod(j+i,P)+1);
    end
end

for i=1:P % generuj wektor r
    r(i)=rk(i);
end

a = -R\r; % generuj wektor a

% podpunkt 4
M = 24000;
e=zeros(1, M);
for i=1:M
    if mod(i, T)==0
        e(i)=1; % co okres T powtarza się otwarcie strun głosowych
    end
end

y = zeros(1, fpr-1);
for n=0:fpr-1
    suma=0;
    for k=1:P
        if(n-k)>0
            suma=suma+a(k)*y(n-k);
        end
    end
    y(n+1) = e(n+1)-suma;
end

% podpunkt 5
% figure(3)
% plot(y);
% soundsc(y, fpr);




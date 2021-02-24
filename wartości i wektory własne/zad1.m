clear all;
close all;
format;
clc;

%% metoda QR

num = 20; % liczba iteracji

A = magic(4); % utwórz macierz 4x4, w której suma z każdego wiersza i każdej kolumny wynosi tyle samo
A(1,3) = 100;
[Q,R] = qr(A);

for i=1:num
    [Q,R] = qr(R*Q);
end

lambda_QR = diag(R*Q); % wartości własne macierzy wyznaczone metodą QR
lambda_eig = eig(A); % wyznacz wartości własne macierzy funkcją matlaba

diff1 = abs(lambda_QR-lambda_eig); % różnica między metodą QR a funkcją matlaba


%% metoda potęgowa

num = 20; % liczba iteracji

A = magic(4); % utwórz macierz 4x4, w której suma z każdego wiersza i każdej kolumny wynosi tyle samo
A(1,3) = 100;

x = ones(length(A),1);
for i = 1:num
    x = A*x; % rekurencyjna metoda potęgowa wyznaczenia wektora własnego macierzy A
end

x = x./x(length(A)); % sprowadź wektor do postaci z jedynką
eigenvalue = dot(A*x, x)/dot(x, x); % oblicz maksymalną wartość własną ze wzoru

diff2 = abs(eigenvalue - max(lambda_eig)); % różnica między metodą potęgową a funkcją matlaba




























clear all;
close all;
format;
clc;

% zad1 dane % rozwiązanie I1 = 53.0579A, I2 = 118.3471A
R1 = 0.005;
R2 = 0.001;
R0 = 0.1;
E1 = 12.1;
E2 = 11.9;
A = [R1+R2, -R2; -R2, R2+R0];
b = [E1-E2; E2];
N = 2;

% N = input('Liczba niewiadomych: ');
% A = randi([0 10], N) % generuj losową macierz NxN o liczbach z zakresu 0-10
% b = randi([0 10], [N 1]) % generuj losową macierz Nx1 o liczbach z zakresu 0-10


for i=1:N
    temp = A(i,i); % zapisz element z przekątnej diagonalnej
    A(i,1:N) = A(i,1:N)/temp; % podziel cały wiersz przez element diagonalny tego wiersza
    b(i,1)=b(i,1)/temp; % podziel macierz b przez element diagonalny
    for j=1:N
        temp = A(j,i); % przechodź w dół po wierszach w danej kolumnie
        if j==i % pomiń element diagonalny 
            continue
        else 
            A(j,1:N) = A(j,1:N) - temp*A(i, 1:N); % wyzeruj element
            b(j,1) = b(j,1) - temp*b(i,1); % aktualizuj macierz b
        end
    end
end

disp("rozwiązania układu: ")
disp(b);

        
    

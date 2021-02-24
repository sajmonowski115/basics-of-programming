clear all;
% close all;
format;
clc;

% rozwiązanie I1 = 53.0579A, I2 = 118.3471A
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


% wykonaj dekompozycję macierzy- algorytm Doolittle'a
L = eye(N); % macierz jednostkowa
U = zeros(N);
for i=1:N
    for j=1:N
        U(i,j) = A(i,j);
        for k=1:(i-1)
            U(i,j)=U(i,j)-L(i,k)*U(k,j);
        end
    end
    for j=(i+1):N
        L(j,i)=A(j,i);
        for k=1:(i-1)
            L(j,i)=L(j,i)-L(j,k)*U(k,i);
        end
        L(j,i)=L(j,i)/U(i,i);
    end
end

% wykonaj podstawienie w przód: L*y=b
y(1)= b(1);
for i=2:N
    sum = 0;
    for j=1:(i-1)
        sum = sum+L(i,j)*y(j);
    end
    y(i)=b(i)-sum;
end
y = y'; % transponuj do wektora kolumnowego

% wykonaj podstawienie wstecz U*x=y
x(N) = y(N)/U(N,N);
for i = N-1:-1:1
    sum = 0;
    for j=(i+1):N
        sum = sum + U(i,j)*x(j);
    end
    x(i) = (y(i) - sum)/U(i, i);
end
x = x'; % transponuj do wektora kolumnowego

disp("rozwiązanie układu: ")
disp(x);

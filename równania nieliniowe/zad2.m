%% zad 2

clear all;
close all;
format;
clc;

%% ustalenie warunków początkowych zadania

A = -1024; % wartość wejściowa

if abs(A) < eps
    disp('Value less than machine epsilon.');
    return
elseif A < 0
    sgn = -1;
elseif A > 0
    sgn = 1;
end
A = abs(A);

%% obliczanie pierwiastka

nrit = 100; % liczba iteracji

funct = @(x,a)(x^2-a); % wzór funkcji pierwotnej
derivative = @(x)(2*x); % pierwsza pochodna

root = 1;
for i = 1:nrit
    root = root - funct(root, A)/derivative(root); % metoda Newtona-Raphsona
end

disp(['root of ', num2str(A), ' equals ', num2str(root)]);


%% obliczanie wartości odwrotnej

funct = @(x,a)(1/x - a);
derivative = @(x)(-1/x^2);

nrit = 500; % liczba iteracji
inv = eps; % ustaw epsilon maszynowy jako wartość pierwszego szacowania  

for i = 1:nrit
    if (inv*A) <= 1 % warunek zbieżności
        inv = inv - funct(inv, A)/derivative(inv); % metoda Newtona-Raphsona
    else
        break
    end
end

if sgn == 1 % wartość wejściowa większa od zera
    disp(['inverse of ', num2str(A), ' equals ', num2str(inv)]);
else % wartość wejściowa mniejsza od zera
    disp(['inverse of ', num2str(-A), ' equals ', num2str(-inv)]);
end


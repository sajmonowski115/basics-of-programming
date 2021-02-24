clear all;
close all;
format;
clc;

%% wyniki pomiaru temperatury
xk = [5, 6, 8, 11]; % wektor wszystkich znanych argumentów (wektor N-elementowy)
yk = [1, 2, 7, 15]; % wektor wszystkich znany wartości (wektor N-elementowy)
[M, N] = size(xk);


%% metoda Lagrange'a 
for x = 50:110 % oblicz wyniki metody Lagrange'a i zapisz w zmiennej lag_y
    lag_y(x) = 0;
    for k=1:N
        lag_y(x) = lag_y(x) + yk(k)*Lk(x/10, xk, k);
    end
end

%% metoda Newtona
d(:,1) = yk; % oblicz parametry d na podstawie kodu z zadania
for j=2:N
    for k=j:N
        d(k,j) = (d(k,j-1) - d(k-1, j-1)) / (xk(k) - xk(k-j+1));
    end
end

for x=50:110 % oblicz wyniki metody Newtona i zapisz w zmiennej nwt_y
    nwt_y(x) = d(1,1);
    for k=1:N-1
        product = 1;
        for j=1:k
            product = product * (x/10-xk(j));
        end
        nwt_y(x) = nwt_y(x) + d(k+1, k+1) * product;
    end
end

%% porównanie
for i = 50:110
    diff(i) = abs(lag_y(i) - nwt_y(i));
end

%% wykresy

% argumenty oraz ich wartości dane w zadaniu
known_points(1, 50) = 1;
known_points(1, 60) = 2;
known_points(1, 80) = 7;
known_points(1, 110) = 15;

% szkicuj dwa przebiegi wielomianów
hold on;
title("Lagrange and Newton methods on one plot");
plot(known_points, 'g*');
plot(lag_y, '-b');
plot(nwt_y, '--r');
xlim([50 110]);
ylim([1 15]);

%% zadania

% oblicz temperaturę o godzinie 7:15
temperature = (lag_y(72) + lag_y(73)) / 2;
disp("Lagrange interpolation:" + newline + "Temperature at 7:15: " + num2str(temperature) + " Celsius degrees");
temperature = (nwt_y(72) + nwt_y(73)) / 2;
disp("Newton interpolation:" + newline + "Temperature at 7:15: " + num2str(temperature) + " Celsius degrees");


% % oblicz, o której temperatura przekroczyła 3 stopnie
[M, N] = size(yk);
for x=10:150
    lag_y(x) = 0;
    for k=1:N
        lag_y(x) = lag_y(x) + xk(k) * Lk(x/10, yk, k);
    end
end

result = lag_y(30);
h = floor(result);
m = floor((result-floor(result))*60);
h = num2str(h);
m = num2str(m);
print2 = ['', h, ':', m, '.'];
disp("Temperature passed 3 Celsius degrees at " + print2);




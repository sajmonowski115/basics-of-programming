clear all;
close all;
format;
clc;

logi = csvread('accel_logs2.csv', 1, 0);

%% odczytywanie wartości logów do zmiennych
acc_x = logi(:,1); % wektor x przyspieszenia
acc_y = logi(:,2); % wektor y przyspieszenia
acc_z = logi(:,3); % wektor z przyspieszenia
time = logi(:,4); % wektor pomiarów (czas kolejnych pomiarów)

[len, tmp] = size(acc_x); % ilość pomiarów
clear tmp;


%% obliczenia

% zmierz wartość przyspiesznia dla każdego pomiaru
for i=1:len
    acc(i,:) = sqrt(acc_x(i,1)^2 + acc_y(i,1)^2 + acc_z(i,1)^2);
end

% wartość przyspieszenie -> szybkość chwilowa | metoda trapezów
v = velocity(acc, time);

% szybkość chwilowa -> przebywana droga | metoda trapezów
s = distance(v, time);

disp("Final velocity: " + num2str(v(len))); % ostatnia zanotowana wartość prędkości
disp("Total distance: " + num2str(s(len))); % całkowity przebyty dystans


%% obliczenia dla poszczególnych osi

% prędkość i dystans na osi x
v_x = velocity(acc_x, time);
s_x = velocity(v_x, time);

% prędkość i dystans na osi y
v_y = velocity(acc_y, time);
s_y = velocity(v_y, time);

% prędkość i dystans na osi z
v_z = velocity(acc_z, time);
s_z = velocity(v_z, time);


%% porównanie

disp("Velocity calculated with trapz " + num2str(trapz(time, acc)));
disp("Total distance calculated with trapz " + num2str(trapz(time, v)));

% różnica w wynikach implementacji ręcznej z metodą matlaba
v_diff = abs(v(len) - trapz(time, acc)); 
s_diff = abs(s(len) - trapz(time, v));

clear all;
close all;
format;
clc;

%% wczytywanie wartości danych do zmiennych

data = readmatrix("pozycje.txt"); % zapisz dane z pliku pozycje.txt do macierzy
data = data(:,1:5); % usuń ostatnią kolumnę (wartości Nan)s

time = data(:,1)/1000; % czas wyrażony sekundach
latitude = data(:,2); % szerokość geograficzna w stopniach
longitude = data(:,3); % długość geograficzna w stopniach
altitude = data(:,4); % wysokość nad poziomem morza w metrach
accuracy = data(:,5); % dokładność pomiaru wyrażona w metrach

[len, tmp] = size(time); % ilość pomiarów
clear tmp;

%% przejście ze stopni na radiany

for i = 1:len
    latitude(i) = latitude(i)*(pi/180);
    longitude(i) = longitude(i)*(pi/180);
end

%% przejście ze współrzędnych geograficznych na metry

% oblicz odległości pomiędzy poszczególnymi punktami geograficznymi
distance(1) = 0; % przyjmuję pierwszy punkt jako punkt startowy (0,0,0)
for i=2:len 
    distance(i,:) = coordinates_to_distance(latitude(i-1), longitude(i-1), latitude(i), longitude(i));
end


%% obliczanie pochodnych

% oblicz prędkość jako pochodną drogi po czasie
v(1) = 0; % przyjmuję, że początkowa wartość prędkości wynosi zero
for i=2:len
    dx = sqrt((altitude(i)-altitude(i-1))^2 + distance(i)^2);
    dt = time(i) - time(i-1);
    v(i,:) = dx/dt;
end

% oblicz przyspieszenie jako pochodną prędkości po czasie
acc(1) = 0; % przyjmuję, że początkowe przyspieszenie wynosi zero
for i=2:len
    dv = v(i) - v(i-1);
    dt = time(i) - time(i-1);
    acc(i,:) = dv/dt;
end


%% całkowita droga

% oblicz całkowitą przebytą drogę
total_distance = 0;
for i=2:len
    dx(i) = sqrt((altitude(i)-altitude(i-1))^2 + distance(i)^2);
    total_distance = total_distance + dx(i);
end

disp("Total distance: " + num2str(round(total_distance/1000, 2)) + " km");


%% metoda matlaba

s(1) = 0;
for i=2:len
    s(i) = s(i-1) + sqrt((altitude(i)-altitude(i-1))^2 + distance(i)^2);
end

v_diff = diff(s') ./ diff(time);

difference = abs(v_diff - v(2:len, 1));






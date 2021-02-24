%% zad 3

clear all;
close all;
format;
clc;

%% wczytywanie wartości danych do zmiennych

data = readmatrix("pozycje.txt"); % zapisz dane z pliku pozycje.txt do macierzy
data = data(:,1:5); % usuń ostatnią kolumnę (wartości Nan)

time = data(:,1)/1000; % czas wyrażony sekundach
latitude = data(:,2); % szerokość geograficzna w stopniach
longitude = data(:,3); % długość geograficzna w stopniach
altitude = data(:,4); % wysokość nad poziomem morza w metrach
accuracy = data(:,5); % dokładność pomiaru wyrażona w metrach

[len, ~] = size(time); % ilość pomiarów

%% przejście ze stopni na radiany

for i = 1:len
    latitude(i) = latitude(i)*(pi/180);
    longitude(i) = longitude(i)*(pi/180);
end

%% przejście ze współrzędnych geograficznych na metry

% oblicz odległości pomiędzy poszczególnymi punktami geograficznymi
distance = zeros(len,1); % przyjmuję pierwszy punkt jako punkt startowy (0,0,0)
for i=2:len 
    distance(i,:) = coordinates_to_distance(latitude(i-1), longitude(i-1), latitude(i), longitude(i));
end


%% obliczanie pochodnych

% oblicz prędkość jako pochodną drogi po czasie
v = zeros(len,1); % przyjmuję, że początkowa wartość prędkości wynosi zero
for i=2:len
    dx = sqrt((altitude(i)-altitude(i-1))^2 + distance(i)^2);
    dt = time(i) - time(i-1);
    v(i,:) = dx/dt;
end

% oblicz przyspieszenie jako pochodną prędkości po czasie
acc = zeros(len,1); % przyjmuję, że początkowe przyspieszenie wynosi zero
for i=2:len
    dv = v(i) - v(i-1);
    dt = time(i) - time(i-1);
    acc(i,:) = dv/dt;
end


%% wyznaczanie ile razy samochód zwolnił / przyspieszył

down = 0; % ile razy zwolnił
up = 0; % ile razy przyspieszył
last = 0; % ostatnia wartość przyspieszenia

for i = 1:length(acc)
    if acc(i) > 0 && last <= 0
        up = up + 1;
        last = 1;
    elseif acc(i) < 0 && last >= 0
        down = down + 1;
        last = -1;
    end
end

disp(['The vehicle sped up ', num2str(up), ' times']);
disp(['The vehicle slowed down ', num2str(down), ' times']);


%% funkcja obliczająca odległość punktów na podstawie ich współrzędnych geograficznych

function [s] = coordinates_to_distance(latitude1, longitude1, latitude2,longitude2)
    fi_1 = latitude1; % szerokość geograficzna punktu początkowego
    lm_1 = longitude1; % długość geograficzna punktu początkowego
    fi_2 = latitude2; % szerokość geograficzna punktu końcowego
    lm_2 = longitude2; % długość geograficzna punktu końcowego
    
    delta_fi = fi_2 - fi_1; % różnica szerokości geograficznych
    delta_lm = lm_2 - lm_1; % różnica długości geograficznych
    R = 6371000; % promień ziemi w metrach
    
    % oblicz współczynniki a oraz c
    a = (sin(delta_fi/2))^2 + cos(fi_1)*cos(fi_2)*(sin(delta_lm/2))^2;
    c = 2*atan2( sqrt(a), sqrt(1-a) );
    
    s = R*c; % odległość punktów w metrach
end




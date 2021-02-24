clear all;
close all;
format;
clc;

%% wczytaj dane z pliku do zmiennych

data = csvread('LoudnessWarNumbers.csv');

year = data(:,1);
avg = data(:,2);
min = data(:,3);
max = data(:,4);
N = length(year);

%% regresja liniowa dla wartości minimalnych
[a_min,b] = linear_regression(year, min, N);
disp_graph(year, min, a_min, b, 'minimum', 1);

%% regresja liniowa dla wartości średnich
[a_avg,b] = linear_regression(year, avg, N);
disp_graph(year, avg, a_avg, b, 'average', 2);

%% regresja liniowa dla wartości maksymalnych
[a_max,b] = linear_regression(year, max, N);
disp_graph(year, max, a_max, b, 'maximum', 3);




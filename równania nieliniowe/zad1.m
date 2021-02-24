%% zad 1

clear all;
close all;
format;
clc;

num_of_itrs = 30; % liczba iteracji

%% metoda bisekcji
a=1; % lewy kraniec przedziału
b=5; % prawy kraniec przedziału
c = (a+b)/2; % pierwsze szacowanie
result(1,1) = c;

for i=1:num_of_itrs
    if sin(a)*sin(c)<0
        b = c;
    else
        a = c;
    end
    c = (a+b)/2; % szacowanie
    result(1,i+1) = c;
end

root(1,1) = c; % wartość znalezionego pierwiastka

%% metoda regula-falsi
a=1; % lewy kraniec przedziału
b=5; % prawy kraniec przedziału
c = b - ( sin(b)*(b-a) / (sin(b)-sin(a)) ); % pierwsze szacowanie
result(2,1) = c;

for i=1:num_of_itrs
    if sin(a)*sin(c)<0
            b = c;
        else
            a = c;
    end
    c = b - ( sin(b)*(b-a) / (sin(b)-sin(a)) ); % kolejne szacowanie
    result(2,i+1) = c;
end

root(1,2) = c; % wartość znalezionego pierwiastka


%% metoda siecznych
a=1; % lewy kraniec przedziału
b=5; % prawy kraniec przedziału
c = b - ( sin(b)*(b-a) / (sin(b)-sin(a)) ); % pierwsze szacowanie
result(3,1) = c;

for i=1:num_of_itrs
    if abs(c-a) < abs(c-b)
            b = c;
        else
            a = c;
    end
    if i >= 6
        result(3,i+1) = c;
        continue
    end
    c = b - ( sin(b)*(b-a) / (sin(b)-sin(a)) ); % kolejne szacowanie
    result(3,i+1) = c;
end

root(1,3) = c; % wartość znalezionego pierwiastka

%% motoda Newtona-Raphsona
a=1; % lewy kraniec przedziału
b=5; % prawy kraniec przedziału
c = (a+b)/2;
result(4,1) = c;

for i=1:num_of_itrs
   c = c - sin(c)/cos(c); % kolejne szacowanie
   result(4, i+1) = c;
end

root(1,4) = c; % wartość znalezionego pierwiastka

%% porównanie błędu oszacowania

estimation_error = zeros(4,11);
for i=1:4
    for j=1:num_of_itrs
        estimation_error(i,j) = abs(pi-result(i,j)); % pi jest pierwiastkiem sin(x)
    end
end

hold on
title('porównanie błędu oszacowania');
plot(estimation_error(1,:), 'r'); % metoda bijekcji- czerwony
plot(estimation_error(2,:), 'g'); % regula-falsi- zielony
plot(estimation_error(3,:), 'b'); % metoda siecznych- niebieski
plot(estimation_error(4,:), 'k'); % Newtona-Raphsona- czarny

%% wyliczenie wartości pierwiatków sinusa w przedziale 1-7

a=1; % lewy kraniec przedziału
b=4; % prawy kraniec przedziału
c = (a+b)/2;
for i=1:num_of_itrs
   c = c - sin(c)/cos(c); % kolejne szacowanie
end
root_one = c; % wartość znalezionego pierwiastka
disp(['first root: ', num2str(root_one)])

a=4; % lewy kraniec przedziału
b=7; % prawy kraniec przedziału
c = (a+b)/2;
for i=1:num_of_itrs
   c = c - sin(c)/cos(c); % kolejne szacowanie
end
root_two = c; % wartość znalezionego pierwiastka
disp(['second root: ', num2str(root_two)])





    
    

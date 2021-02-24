clear all;
close all;
format;
clc;

%% ustalenie warunków początkowych zadania - podpunkt 1
area = @(r) 2*pi*r^2 + 0.66/r;
a = eps; % pierwsze oszacowanie lewego krańca
b = 3; % pierwsze oszacowanie prawego krańca

%% metoda złotego podziału - podpunkt 1
k = (sqrt(5)-1)/2; % stosunek podziału
xL = b-k*(b-a);
xR = a+k*(b-a);

i = 0; % zmienna do obliczania ilości potrzebnych iteracji
while (b-a) > 1e-6 % zakończ poszukiwanie przy wskazanej dokładności
    i = i + 1;
    if area(xL) < area(xR)
        b = xR; 
        xR = xL;
        xL = b-k*(b-a);
    else
        a = xL; 
        xL = xR;
        xR = a+k*(b-a);
    end
end

% wyznacz wartości końcowe
r_opt1 = (a+b)/2; % promień
d_opt1 = 2*r_opt1; % średnica
H_opt1 = 0.33/(pi*r_opt1^2); % wysokość

disp('pierwszy przypadek');
disp(['średnica: ', num2str(d_opt1)]);
disp(['wysokość: ', num2str(H_opt1)]);
disp(['ilość potrzebnych iteracji: ', num2str(i)]);
%% ustalenie warunków początkowych zadania - podpunkt 2
area = @(r) 4*pi*r^2 + 0.66/r;
a = eps; % pierwsze oszacowanie lewego krańca
b = 3; % pierwsze oszacowanie prawego krańca

%% metoda złotego podziału - podpunkt 2
k = (sqrt(5)-1)/2; % stosunek podziału
xL = b-k*(b-a);
xR = a+k*(b-a);

j = 0; % zmienna do obliczania ilości potrzebnych iteracji
while (b-a) > 1e-6 % zakończ poszukiwanie przy wskazanej dokładności
    j = j + 1;
    if area(xL) < area(xR)
        b = xR; 
        xR = xL;
        xL = b-k*(b-a);
    else
        a = xL; 
        xL = xR;
        xR = a+k*(b-a);
    end
end

% wyznacz wartości końcowe
r_opt2 = (a+b)/2; % promień
d_opt2 = 2*r_opt2; % średnica
H_opt2 = 0.33/(pi*r_opt2^2); % wysokość

disp('drugi przypadek');
disp(['średnica: ', num2str(d_opt2)]);
disp(['wysokość: ', num2str(H_opt2)]);
disp(['ilość potrzebnych iteracji: ', num2str(j)]);

%% wykresy
% figure(1);
% plot(r1, area1);
% title("pierwszy podpunkt");
% figure(2);
% plot(r2, area2);
% title("drugi podpunkt");

%% wyczyszczenie nieistotnych parametrów
clear a b k xL xR area i j;
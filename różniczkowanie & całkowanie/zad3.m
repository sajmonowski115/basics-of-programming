clear all;
close all;
format;
clc;

x=0:((2*pi)/100):2*pi;
y1 = sin(x);
y2 = cos(x);

%% 1. różnicowanie sinusa bez szumu
% wykonaj różnicowanie metodą ilorazów różnicowych centralnych
A(1) = y2(1);
for i=2:100
    A(i) = (y1(i+1)-y1(i-1)) / (x(i+1)-x(i-1));
end

% wykonaj różnicowanie metodą ilorazów różnicowych wstecz
B(1) = y2(1);
for i=2:100
    B(i) = (y1(i)-y1(i-1)) / (x(i)-x(i-1));
end

% porównaj otrzymane wyniki w rzeczywitą pochodną
for i=1:100
    central_diff(i) = abs(y2(i)- A(i)); % metoda różnicowania centralnego
    regress_diff(i) = abs(y2(i) - B(i)); % metoda różnicowania wstecz
end

%% 2. różnicowanie sinusa z szumem białym
y_20dB = awgn(y1, 20);
y_35dB = awgn(y1,35);
y_50dB = awgn(y1, 50);

% różnicowanie dla szumu 20dB
for i=2:100
    A_20dB(i) = (y_20dB(i+1) - y_20dB(i-1)) / (x(i+1)-x(i-1));
    B_20dB(i) = (y_20dB(i) - y_20dB(i-1)) / (x(i)-x(i-1));
end

% różnicowanie dla SNR 35dB
for i=2:100
    A_35dB(i) = (y_35dB(i+1) - y_35dB(i-1)) / (x(i+1)-x(i-1));
    B_35dB(i) = (y_35dB(i) - y_35dB(i-1)) / (x(i)-x(i-1));
end

% różnicowanie dla SNR 50dB
for i=2:100
    A_50dB(i) = (y_50dB(i+1) - y_50dB(i-1)) / (x(i+1)-x(i-1));
    B_50dB(i) = (y_50dB(i) - y_50dB(i-1)) / (x(i)-x(i-1));
end

% porównaj otrzymane wyniki z rzeczywistą pochodną
for i=1:100
    A_20dB_diff(i) = abs(y2(i) - A_20dB(i));
    B_20dB_diff(i) = abs(y2(i) - B_20dB(i));
    
    A_35dB_diff(i) = abs(y2(i) - A_35dB(i));
    B_35dB_diff(i) = abs(y2(i) - B_35dB(i));
    
    A_50dB_diff(i) = abs(y2(i) - A_50dB(i));
    B_50dB_diff(i) = abs(y2(i) - B_50dB(i));
end



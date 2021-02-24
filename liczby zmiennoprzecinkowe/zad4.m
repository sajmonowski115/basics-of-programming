clear all;
close all;
clc;

x=realmin; 
n=1;
while(x<realmax)
   x=2*x; 
   n=n+1;   
end
n=n+1;
liczba_bitow_wykladnika = log2(n);

disp(n);
fprintf("Liczba bitow wykładnika: ");  disp(liczba_bitow_wykladnika);
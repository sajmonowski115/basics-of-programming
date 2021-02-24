clear all;
close all;
clc;

d = ones(1, 1024);% utworzenie wektora 1x1024

for i = 10:1024 
    d(i) = xor(d(i-4), d(i-9));
end

cor = xcorr(d, 'unbiased');  
plot(cor);

%powtarza sie po 511 bitach
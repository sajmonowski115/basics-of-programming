clear all;
close all;
format;
clc;

% generuj macierz rzadką o wymiarach 100 x 100
n = 100;
i = 1:n;
j = 1:n;
for ii=3:n-3
    i(ii) = i(ii) + randi([-2,2],1,1);
%     i(ii) = ii;
    j(ii) = j(ii) + randi([-2,2],1,1);
%     j(ii) = ii ;
end
s1 = randi([1, 10],1,n);
s2 = randi([1,10],1,n);
A1 = sparse(i,j,s1,n,n);
A2 = sparse(1:n,1:n,s2,n,n);
A = A1+A2;

A = full(A); % gotowa, wygenerowana macierz rzadka
b = randi([1 10], [n 1]); % generuj n randomowych rozwiązań z przedziału 1-10

D = diag(diag(A));
L = tril(A)-D; % dolna trójkątna część macierzy rzadkiej
U = triu(A)-D; % górna trójkątna część macierzy rzadkiej

x = ones(n, 1);
z = ones(n, 1);

for i=1:10
   x = inv(D)*(b-(L+U)*z);
   z=x; 
end
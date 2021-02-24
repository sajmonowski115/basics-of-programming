clear all;
close all;
format;
clc;

number_of_samples = 50;

overall_time = 0; % całkowity czas wszystkich prób
for i = 1:number_of_samples % zmierz czas rozwiązywania układów metodą Jacobiego
    [N, A, b] = generate_random_sparse_matrix(100);
    tic;
    Jacobi_method(N, A, b);
    time = toc; % zmierz czas pojedyńczej próby
    overall_time = overall_time + time;
end
fprintf("Średni czas rozwiązywania układu metodą Jacobiego: "); 
disp(overall_time/number_of_samples);

overall_time = 0; % całkowity czas wszystkich prób
for i = 1:number_of_samples % zmierz czas rozwiązywania układów metodą LU
    [N, A, b] = generate_random_sparse_matrix(100);
    tic;
    LU_method(N, A, b);
    time = toc; % zmierz czas pojedyńczej próby
    overall_time = overall_time + time;
end
fprintf("Średni czas rozwiązywania układu metodą LU: "); 
disp(overall_time/number_of_samples);

for i = 1:number_of_samples
    [N, A, b] = generate_random_sparse_matrix(100);
    result_Jacobi = Jacobi_method(N, A, b);
    result_LU = LU_method(N, A, b);
    result = abs(result_Jacobi - result_LU);
end

function [x] = Jacobi_method(n, A, b)

    D = diag(diag(A));
    
    L = tril(A)-D; % dolna trójkątna część macierzy rzadkiej
    U = triu(A)-D; % górna trójkątna część macierzy rzadkiej
    
    x = zeros(n, 1);
    z = zeros(n, 1);
    
    for i=1:10
        x = inv(D)*(b-(L+U)*z);
        z=x; 
    end
end
function [x] = LU_method(N, A, b)
    % wykonaj dekompozycję macierzy
    L = eye(N); % macierz jednostkowa
    U = zeros(N);
    for i=1:N
        for j=1:N
            U(i,j) = A(i,j);
            for k=1:(i-1)
                U(i,j)=U(i,j)-L(i,k)*U(k,j);
            end
        end
        for j=(i+1):N
            L(j,i)=A(j,i);
            for k=1:(i-1)
                L(j,i)=L(j,i)-L(j,k)*U(k,i);
            end
            L(j,i)=L(j,i)/U(i,i);
        end
    end

    % wykonaj podstawienie w przód: L*y=b
    y(1)= b(1);
    for i=2:N
        suma = 0;
        for j=1:(i-1)
            suma = suma+L(i,j)*y(j);
        end
        y(i)=b(i)-suma;
    end
    y = y'; % transponuj do wektora kolumnowego

    % wykonaj podstawienie wstecz U*x=b 
    x(N) = y(N)/U(N,N);
    for i = N-1:-1:1
        suma = 0;
        for j=(i+1):N
            suma = suma + U(i,j)*x(j);
        end
        x(i) = (y(i) - suma)/U(i, i);
    end
    x = x';
end
function [n, A, b] = generate_random_sparse_matrix(n)
    % generuj macierz rzadką o wymiarach 100 x 100
    n = 100;
    i = 1:n;
    j = 1:n;
    for ii=3:n-3
        i(ii) = i(ii) + randi([-2,2],1,1);
%         i(ii) = ii;
        j(ii) = j(ii) + randi([-2,2],1,1);
%         j(ii) = ii ;
    end
    s1 = randi([1, 10],1,n);
    s2 = randi([1,10],1,n);
    A1 = sparse(i,j,s1,n,n);
    A2 = sparse(1:n,1:n,s2,n,n);
    A = A1+A2;

A = full(A); % gotowa, wygenerowana macierz rzadka
b = randi([1 10], [n 1]); % generuj n randomowych rozwiązań z przedziału 1-10
end
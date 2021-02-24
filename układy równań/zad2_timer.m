clear all;
close all;
format;
clc;

number_of_samples = 50;

overall_time = 0; % całkowity czas wszystkich prób
for i = 1:number_of_samples % zmierz czas rozwiązywania układów metodą Gaussa-Jordana
    [N, A, b] = generate_random_system_of_equations(100);
    tic;
    Gauss_Jordan_method(N, A, b);
    time = toc; % zmierz czas pojedyńczej próby
    overall_time = overall_time + time;
end
fprintf("Średni czas rozwiązywania układu metodą Gaussa-Jordana: "); 
disp(overall_time/number_of_samples);

overall_time = 0; % całkowity czas wszystkich prób
for i = 1:number_of_samples % zmierz czas rozwiązywania układów metodą LU
    [N, A, b] = generate_random_system_of_equations(100);
    tic;
    LU_method(N, A, b);
    time = toc; % zmierz czas pojedyńczej próby
    overall_time = overall_time + time;
end
fprintf("Średni czas rozwiązywania układu metodą LU: "); 
disp(overall_time/number_of_samples);


%porównaj wyniki obu metod
for i = 1:number_of_samples
    [N, A, b] = generate_random_system_of_equations(100);
    result_Gauss = Gauss_Jordan_method(N, A, b);
    result_LU = LU_method(N, A, b);
    result = abs(result_Gauss - result_LU);
end



function [b] = Gauss_Jordan_method(N, A, b)
    for i=1:N
        temp = A(i,i); % zapisz element z przekątnej diagonalnej
        A(i,1:N) = A(i,1:N)/temp; % podziel cały wiersz przez element diagonalny tego wiersza
        b(i,1)=b(i,1)/temp; % podziel macierz b przez element diagonalny
        for j=1:N
            temp = A(j,i); % przechodź w dół po wierszach w danej kolumnie
            if j==i % pomiń element diagonalny 
                continue
            else 
                A(j,1:N) = A(j,1:N) - temp*A(i, 1:N); % wyzeruj element
                b(j,1) = b(j,1) - temp*b(i,1); % aktualizuj macierz b
            end
        end
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
function [N, A, b] = generate_random_system_of_equations(N)
    A = randi([0 10], N); % generuj losową macierz NxN o liczbach z zakresu 0-10
    b = randi([0 10], [N 1]); % generuj losową macierz Nx1 o liczbach z zakresu 0-10
end
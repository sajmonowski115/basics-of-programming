function y = Lk(x, xk, k)
% x - argument x (skalar)
% xk - wektor wszystkich znanych argumentów (wektor N-elementowy)
% k - numer wielomianu
% y - obliczona wartość wielomianu Lk
    
    y = 1;
    [M, N] = size(xk);
    for j=1:N
        if j == k
            continue
        else
            y = y*((x-xk(j))/(xk(k)-xk(j)));
        end
    end
end
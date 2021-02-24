function [a,b] = linear_regression(X, Y, N)
    x = sum(X)/N;
    y = sum(Y)/N;
    xy = sum(X.*Y)/N;
    x_sq = sum(X.*X)/N;
    a = (xy-x*y)/(x_sq-x^2);
    b = y-a*x;
end
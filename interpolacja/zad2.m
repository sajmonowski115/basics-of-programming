clear all;
close all;
format;
clc;

xk = -5:1:5;
yk = 1./(1+xk.^2);
x = (-5:0.01:5);
y = 1./(1+x.^2);
[M, N] = size(xk);

%% metoda Lagrange'a z zadania 1
for i=1:1001
    y1(i) = 0;
    for k=1:N
        y1(i) = y1(i) + Lk(x(i), xk, k)*yk(k);
    end
end

%% funkcja sklejania I stopnia (interpolacja liniowa)
y2(1001) = yk(11);
for i=1:10
    for k=1:100
        y2((i-1)*100+k) = yk(i) + ((yk(i+1) - yk(i)) / (xk(i+1)-xk(i)))*(x((i-1)*100+k)-xk(i));
    end
end


%% funkcja sklejania III stopnia (cubic spline)
cs = spline( xk, [0 yk 0] );
y3 = ppval(cs, x);


%% wykresy
hold on;
title("Comparison of different interpolation methods");
plot(x, y, '--y'); % funkcja f(x)
plot(xk, yk, 'yo'); % punkty podane w treści zadania
plot(x, y1, 'r'); % interpolacja Lagrange'a
plot(x, y2, 'b'); % funkcja sklejania I stopnia
plot(x, y3, 'k'); % funkcja sklejania III stopnia


%% maksymalne różnice przybliżeń funkcji
diff(1,:) = abs(y1-y); % różnice w metodzie Lagrange'a
diff(2,:) = abs(y2-y); % różnice dla funkcji sklejania pierwszego stopnia
diff(3,:) = abs(y3-y); % różnice dla funkcji sklejania trzeciego stopnia

max_diff(1) = max(diff(1,:));
max_diff(2) = max(diff(2,:));
max_diff(3) = max(diff(3,:));

disp("Max differences for: ");
disp("*Lagrange method: " + num2str(max_diff(1)));
disp("*spline interpolation: " + num2str(max_diff(2)));
disp("*cubic spline interpolation: " + num2str(max_diff(3)));
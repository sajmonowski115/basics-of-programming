function [] = disp_graph(X, Y, a, b, name, num)
    figure(num);
    title(name);
    hold on
    plot(X,Y,'o');
    plot(X, a*X+b);
end
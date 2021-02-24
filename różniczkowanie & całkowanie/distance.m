function [s] = distance(v, time)
    temp = 0;
    [len, temp] = size(v); % ilość pomiarów
    clear temp;
    s = zeros(len, 1); % zakładam, że zaczynamy przy zerowej przebytej drodze
    for i=2:len
        s(i,1) = s(i-1, 1) + ((v(i,1) + v(i-1, 1)) / 2) * (time(i,1) - time(i-1,1));
    end
end
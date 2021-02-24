function [v] = velocity(acc, time)
    temp = 0;
    [len, temp] = size(acc); % ilość pomiarów
    clear temp;
    v = zeros(len, 1); % zakładam, że prędkość początkowa wynosiła zero
    for i=2:len
        v(i,1) = v(i-1,1) + ((acc(i, 1) + acc(i-1,1)) / 2) *  (time(i,1) - time(i-1,1));
    end
end
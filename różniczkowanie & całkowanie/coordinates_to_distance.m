function [s] = coordinates_to_distance(latitude1, longitude1, latitude2,longitude2)
    fi_1 = latitude1; % szerokość geograficzna punktu początkowego
    lm_1 = longitude1; % długość geograficzna punktu początkowego
    fi_2 = latitude2; % szerokość geograficzna punktu końcowego
    lm_2 = longitude2; % długość geograficzna punktu końcowego
    
    delta_fi = fi_2 - fi_1; % różnica szerokości geograficznych
    delta_lm = lm_2 - lm_1; % różnica długości geograficznych
    R = 6371000; % promień ziemi w metrach
    
    % oblicz współczynniki a oraz c
    a = (sin(delta_fi/2))^2 + cos(fi_1)*cos(fi_2)*(sin(delta_lm/2))^2;
    c = 2*atan2( sqrt(a), sqrt(1-a) );
    
    s = R*c; % odległość punktów w metrach
end
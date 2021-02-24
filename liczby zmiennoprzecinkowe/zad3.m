clear all;
close all;
clc;

iterations = 0;
epsilon = 1;

while ((1 + epsilon) > 1)
    epsilon = epsilon/2;
    iterations = iterations+1;
end

fprintf("epsilon: "); disp(epsilon);
fprintf("mantissa bits: "); disp(iterations);
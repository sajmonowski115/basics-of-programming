clear all;
close all;
clc;

show_results = 1;

a1 = single(0.1);
b1 = single(-100);
c1 = single(0.1);

a2 = double(0.1);
b2 = double(-100);
c2 = double(0.1);

x1_1s = (-b1 + sqrt(b1^2 - 4*a1*c1))/(2*a1);
x1_2s = (-b1 - sqrt(b1^2 - 4*a1*c1))/(2*a1);
x1_1d = (-b2 + sqrt(b2^2 - 4*a2*c2))/(2*a2);
x1_2d = (-b2 - sqrt(b2^2 - 4*a2*c2))/(2*a2);

x2_1s = (-2*c1)/(b1 + sqrt(b1^2 - 4*a1*c1));
x2_2s = (-2*c1)/(b1 - sqrt(b1^2 - 4*a1*c1));
x2_1d = (-2*c2)/(b2 + sqrt(b2^2 - 4*a2*c2));
x2_2d = (-2*c2)/(b2 - sqrt(b2^2 - 4*a2*c2));

cond1_1s = abs(((x1_1s-1.01*x1_1s)/x1_1s)/((b1-1.01))/b1);
cond1_2s = abs(((x1_2s-1.01*x1_2s)/x1_2s)/((b1-1.01))/b1);
cond2_1s = abs(((x2_1s-1.01*x2_1s)/x2_1s)/((b1-1.01))/b1);
cond2_2s = abs(((x2_2s-1.01*x2_2s)/x2_2s)/((b1-1.01))/b1);
cond1_1d = abs(((x1_1d-1.01*x1_1d)/x1_1d)/((b2-1.01))/b2);
cond1_2d = abs(((x1_2d-1.01*x1_2d)/x1_2d)/((b2-1.01))/b2);
cond2_1d = abs(((x2_1s-1.01*x2_1s)/x2_1d)/((b2-1.01))/b2);
cond2_2d = abs(((x2_2s-1.01*x2_2s)/x2_2d)/((b2-1.01))/b2);

if(show_results)
    fprintf('x1_1s: '); disp(x1_1s);
    fprintf("x1_2s: "); disp(x1_2s);
    fprintf("x2_1s: "); disp(x2_1s);
    fprintf("x2_2s: "); disp(x2_2s);
    fprintf("x1_1d: "); disp(x1_1d);
    fprintf("x1_2d: "); disp(x1_2d);
    fprintf("x2_1d: "); disp(x2_1d);
    fprintf("x2_2d: "); disp(x2_2d);
    fprintf("cond1_1s: "); disp(cond1_1s);
    fprintf("cond1_2s: "); disp(cond1_2s);
    fprintf("cond2_1s: "); disp(cond2_1s);
    fprintf("cond2_2s: "); disp(cond2_2s);
    fprintf("cond1_1d: "); disp(cond1_1d);
    fprintf("cond1_2d: "); disp(cond1_2d);
    fprintf("cond2_1d: "); disp(cond2_1d);
    fprintf("cond2_2d: "); disp(cond2_2d);
end

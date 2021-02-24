clear all;
close all;
format;
clc;

full_A = [0 0 0 0 9 0; 0 8 0 0 0 0; 4 0 0 2 0 0; 0 0 0 0 0 5; 0 0 2 0 0 0];

disp(full_A);

sparse_A = sparse([1 2 3 3 4 5], [5 2 1 4 6 3], [9 8 4 2 5 2], 5, 6, 6);

disp(sparse_A);

disp(full(sparse_A));
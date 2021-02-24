clear all;
close all;
format;
clc;

load ('lab_10_2.dat'); in_all = lab_10_2; clear lab_10_2;

in = in_all(:,1);

initial_f = 1;
initial_A = 1;
initial_a = 1;

% estymacja parametrów
initParm = [ initial_f, initial_A, initial_a ]; % parametry początkowe
outParm = fminsearch( @(x) fitSinDump(x, in, fs, Nx) , initParm );

estimated_f = outParm(1);
estimated_A = outParm(2);
estimated_a = outParm(3);
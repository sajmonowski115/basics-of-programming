clear all; 
close all; 
clc;

load('h.mat');

N = 32;
F = zeros(32, 32);

for n=0:31
    for m=0:31
        F(n+1,m+1)=(1/sqrt(N))*cos(2*(pi/N)*n*m)-1i*(1/sqrt(N))*sin(2*(pi/N)*n*m);
    end
end

x = zeros(32,1); % Sygnał u3 z zad 1 (poprzednie)
for k=0:31
    x(k+1) = sin(2*pi*2*k/N) + sin(2*pi*6*k/N);
end


% OBLICZENIA DLA SIN 

X = F*x; % Transformata sygnału

figure(1);
subplot(2,1,1);
X_plot = 20*log10(abs(X));
plot(X_plot, 'r');
title('Widmo gęstości mocy dla X (sin)'); %sygnał w dziedzinie częstotliwości


% spr. czy macierze sa takie same 
x_t1 = inv(F)*X;
x_t2 = ctranspose(F)'*X;

% if(x_t1 == x_t2)
%     disp("Macierze x_t1 i x_t2 są takie same");
% else
%     disp("Macierze x_t1 i x_t2 są różne");
% end  
%     
% if(x_t1 == x)
%     disp("Macierze x i x_t1 są takie same");
% else
%     disp("Macierze x i x_t1 są różne");
% end

x_t1_abs = abs(x - x_t1);
x_t2_abs = abs(x - x_t2);
    

% OBLICZENIA DLA EXP 

x_exp = zeros(32,1); % Sygnał u3 z zad 1, z zamienionym sin na exp

for o=0:31
    x_exp(o+1) = exp(-1i*2*pi*2*o/N) + exp(-1i*2*pi*6*o/N);
end

X_exp = F*x_exp; % Transformata sygnału


X_plot_exp = 20*log10(abs(X_exp));
subplot(2,1,2);
plot(X_plot_exp, 'b');
title('Widmo gęstości mocy dla X (exp)');



x_t1_exp = inv(F)*X_exp;
x_t2_exp = ctranspose(F)'*X_exp;

% if(x_t1_exp == x_t2_exp)
%     disp("Macierze x_t1_exp i x_t2_exp są takie same");
% else
%     disp("Macierze x_t1_exp i x_t2_exp są różne");
% end  
%     
% if(x_exp == x_t2_exp)
%     disp("Macierze x_exp i x_t1 są takie same");
% else
%     disp("Macierze x_exp i x_t1 są różne");
% end 
    
x_t1_exp_abs = x_exp - x_t1_exp;
x_t2_exp_abs = x_exp - x_t2_exp;

% SYGNAŁ Y 
y = conv(h, x); %convolution - splot
Ny = 63;
F_y = zeros(63, 63);

for n=0:62
    for m=0:62
        F_y(n+1,m+1)=(1/sqrt(Ny))*cos(2*(pi/Ny)*n*m)-1i*(1/sqrt(Ny))*sin(2*(pi/Ny)*n*m);
    end
end

Y = F_y*y;

Y_plot = 20*log10(abs(Y));
figure(2);
plot(Y_plot);
title('Widmo gęstości mocy dla Y');

y_t1 = inv(F_y)*Y;
y_t2 = ctranspose(F_y)'*Y;

% if(y_t1 == y_t2)
%     disp("Macierze y_t1 i y_t2 są takie same");
% else
%     disp("Macierze y_t1 i y_t2 są różne");
% end  
%     
% if(y_t1 == y)
%     disp("Macierze y i y_t1 są takie same");
% else
%     disp("Macierze y i y_t1 są różne");
% end 

 y_t1_abs = abs(y - y_t1); 
 y_t2_abs = abs(y - y_t2); 

% SYGNAŁ RANDN 

r = randn(32,1);

R = F*r;

R_plot = 20*log10(abs(R));
plot(R_plot);
title("Widmowa gęstość mocy dla randn()");

r_t1 = inv(F)*R;
r_t2 = ctranspose(F)'*R;

% if(r_t1 == r_t2)
%     disp("Macierze r_t1 i r_t2 są takie same");
% else
%     disp("Macierze r_t1 i r_t2 są różne");
% end  
%     
% if(r_t1 == r)
%     disp("Macierze r i r_t1 są takie same");
% else
%     disp("Macierze r i r_t1 są różne");
% end 

r_t1_abs = abs(r - r_t1);
r_t2_abs = abs(r - r_t2);







clear all; 
close all; 
clc;

load('h.mat');


h = h'; % Transpozycja wektora, aby byla postaci 32x1

% SYGNAL NR 1

u1 = zeros(32,1);
u1(1) = 1;
U1 = toeplitz(u1);
y1 = U1*h;

if(y1 == h)
    disp("y1 jest takie samo jak h");
else
    disp("y1 jest różne od h");
end



% SYGNAL NR 2

u2 = zeros(32,1);
r2 = zeros(1,32);
u2(1:1:7) = [0, 1, 1, 0.5, 0.5, -1, -1];
r2(1) = u2(1); % Konieczne, aby pierwsze wyrazy maciery się zgadzały
U2 = toeplitz(u2, r2);
y2 = U2*h;

figure(1) 
subplot(3,1,1);% kilka wykresów w jednym oknie
stem(u2, 'filled', 'b') 
hold on; 
stem(y2,'filled', 'y') 
title('Sygnał nadany niebieski / odebrany żółty');
hold off;

r_p = zeros(32,1);
p = pinv(h);%macierz pseudoodwrotna do h
r_p(1)=p(1);
P = toeplitz(p, r_p);
y2cor = P*y2;

subplot(3,1,2);
stem(u2, 'filled', 'b');
hold on;
stem(y2cor,'filled', 'r');
title('Po korekcji - nadany niebieski / odebrany czerwony');
hold off;

subplot(3,1,3);
stem(y2, 'filled', 'y')
title('Odebrany przed korekcją żółty / odebrany po korekcji czerwony');
hold on;
stem(y2cor, 'filled', 'r');
hold off;


% SYGNAŁ NR 3

u3 = zeros(32,1);
for i=0:31
    u3(i+1) = sin(2*pi*2*i/32) + sin(2*pi*6*i/32);
end

u3_2hz = zeros(32,1);
for i=0:31
    u3_2hz(i+1) = sin(2*pi*2*i/32);
end

r3 = zeros(1,32);
r3(1) = u3(1); % Pierwsze wyrazy macierzy muszą się zgadzać
U3 = toeplitz(u3,r3);

r3_2hz = zeros(1,32);
r3_2hz(1) = u3_2hz(1);
U3_2hz = toeplitz(u3_2hz, r3_2hz);

y3 = U3*h;
y3_2hz = U3_2hz*h;

figure(2); 
subplot(3,1,1);
hold on;
plot(u3, 'b');
hold on;
title("Sygnał po filtracji zielony");
plot(y3, 'g');
subplot(3,1,2);
plot(u3_2hz, 'b');
hold on;
title("Sygnał po filtracji na wyjsciu (2Hz)");
plot(y3_2hz, 'g');
subplot(3,1,3);
plot(y3, 'g');
title("Sygnały wyjściowe po filtracji 2Hz i 6Hz - zielone oraz 2Hz - czerwone )");
hold on;
plot(y3_2hz, 'r')


%freqz (u3);
%freqz (h);




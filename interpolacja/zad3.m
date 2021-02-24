clear all;
close all;
format;
clc;

%% kod podany w instrukcji

t=pi/6;
rot_mtx=[cos(t), -sin(t); sin(t), cos(t)];
T=[50;-20];
in = imread( 'checkerBoard_20_200.png' );
in = double( rgb2gray( in ) );
N = size( in, 1 );
[X,Y]=meshgrid( 1:N );
XY=[ reshape(X,1,N*N); reshape(Y,1,N*N) ];
XYr=rot_mtx*(XY+repmat(T,1,N*N));
Xi=reshape(XYr(1,:),N,N);
Yi=reshape(XYr(2,:),N,N);

%% wykorzystanie metod Matlaba
out1 = interp2(X, Y, in, Xi, Yi, 'nearest'); 
out2 = interp2(X, Y, in, Xi, Yi, 'linear');

for i=1:200 % rozmiar obrazka to 200x200
    for j=1:200
        if isnan(out1(i,j))
            out1(i,j) = 255;
        end
        if isnan(out2(i,j))
            out2(i,j) = 1;
        end
    end
end

%% interpolacja najbliższego sąsiada
for i=1:200 % rozmiar obrazka to 200x200
    for j=1:200
        % rozmiar in to 200x200, nie można go przekraczać
        if Xi(i, j) <= 200 &&  Xi(i, j) >= 1 && Yi(i, j) <= 200 && Yi(i, j) >= 1
            out(i,j) = in(round(Xi(i, j)), round(Yi(i,j))); % znajdź najbliższego sąsiada i nadaj pikselowi jego wartość
        else
            out(i,j) = 1;
        end
    end
end

%% interpolacja biliniowa
for i=1:200 % rozmiar obrazka to 200x200
    for j=1:200
        % rozmiar in to 200x200, nie można go przekraczać
        if Xi(i, j) <= 200 &&  Xi(i, j) >= 1 && Yi(i, j) <= 200 && Yi(i, j) >= 1
            % określ wartości x1, x2, y1, y2, x, y
            x1 = floor(Xi(i,j));
            x2 = ceil(Xi(i,j)); 
            y1 = floor(Yi(i,j));
            y2 = ceil(Yi(i,j));
            x = Xi(i,j);
            y = Yi(i,j);
            
            % nadaj wartości punktom Q zgodnie z instrukcją
            Q11(i,j) = in(x1, y1);
            Q12(i,j) = in(x1, y2);
            Q21(i,j) = in(x2, y1);
            Q22(i,j) = in(x2, y2);
            
            % oblicz elementy postaci Q*wyrażenie
            one = Q11(i,j)*(x2-x)*(y2-y);
            two = Q21(i,j)*(x-x1)*(y2-y);
            three = Q12(i,j)*(x2-x)*(y-y1);
            four = Q22(i,j)*(x-x1)*(y-y1);
            
            % wszystkie elementy należy podzielić przez ten sam dzielnik
            divider = (x2-x1)*(y2-y1);
            
            P(i,j) = (one+two+three+four)/divider;
        else
            P(i,j) = 1;
        end
    end
end

%% wyświtlanie utworzonych obrazków
subplot(2,2,1);
hold on;
title("Matlab nearest")
imshow(out1);
subplot(2,2,2);
hold on;
title("Matlab linear")
imshow(out2);
subplot(2,2,3);
hold on;
title("Nearest")
imshow(out);
subplot(2,2,4);
hold on;
title("Linear")
imshow(P);

%% zapisywanie obrazków do plików
% imwrite(out, 'nearest.png');
% imwrite(P, 'linear.png');
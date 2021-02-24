function fitness = fitSinDump( parm, x, fs, Nx )
f1 = parm(1);
A = parm(2);
a = parm(3);

t = 1/fs*(0:Nx-1);
y = exp(-a.*t).*A.*sin( 2*pi*f1*t );

fitness = sum( ( x-y ).^2 );

% for debug only
figure(1), plot( t, x, 'k', t, y, 'b.', t, x-y, 'r' ); title( 'in time analysis' );

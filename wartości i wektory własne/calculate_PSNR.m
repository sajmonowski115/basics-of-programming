function [PSNR] = calculate_PSNR(lena, X)
    sum=0;
    max=0;
    
    [rows, columns] = size(X);
    for k=1:rows
        for m=1:columns
            if X(k,m)>max
                max=X(k,m);
            end
            sum = sum + (X(k,m) - lena(k,m))^2;
        end
        MSE = sum/(rows*columns);
        PSNR = 10*log10(max^2/MSE);
    end
end
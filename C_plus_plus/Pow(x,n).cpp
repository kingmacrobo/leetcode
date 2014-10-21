class Solution {
public:
    double pow(double x, int n) {
        if(n==0) return 1;
        if(n<0) {x = 1/x;n = -n;}
        if(n%2==0){
             double temp = pow(x,n/2);
             return temp*temp;
        }
        return x*pow(x,n-1);
    }
};

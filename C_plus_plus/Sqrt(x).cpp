class Solution {
public:
    int sqrt(int x) {
        unsigned long long tmp,k;
        long long start=1,end=x,result=0,min=x;
        while(start<=end){
            k = (start+end)/2;
            tmp = k*k;
            if(tmp == x) return k;
            if(tmp<x){
                start = k+1;
                if(x-tmp<min){min = x -tmp;result = k;}
            }
            else
                end = k-1;
        }
        return result;
    }
};

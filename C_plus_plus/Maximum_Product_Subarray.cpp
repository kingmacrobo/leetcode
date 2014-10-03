class Solution {
public:
    int maxProduct(int A[], int n) {
        int negatives = 0,start = 0,max = 0,nagStart = -1,nagEnd = -1;
        bool first = true;
        if(n==1) return A[0];
        for(int i = 0 ; i < n ; ++i ){
            if(A[i]==0){
                if(i!=0&&A[i-1]!=0){
                    int a = solve(A+start, i - start,nagStart-start,nagEnd-start,negatives);
                    if(a > max) max =a;
                }
                start = i+1;
                negatives = 0;
                nagStart = nagEnd = 0;
                first = true;
            }
            if(A[i]<0){
                if(first){nagStart = i;first = false;}
                ++negatives;
                nagEnd = i;
            }
        }
        if(start<n){
            int a = solve(A+start, n - start,nagStart-start,nagEnd-start,negatives);
            if(a > max) max =a;
        }
        return max;
    }
    int solve(int A[],int n, int nagStart, int nagEnd,int negatives){
        if(n==1) return A[0];
        if(!(negatives%2)){
            int result = 1;
            for(int i = 0 ; i < n ; ++i) result *= A[i];
            return result;
        }
        int r1=1,r2=1;
        for(int i = 0 ; i <=nagEnd-1 ; ++i) r1 *= A[i];
        for(int i = nagStart+1 ; i < n ; ++i) r2 *= A[i];
        r1 = r1>r2?r1:r2;
        r2 = 1;
        for(int i = 0 ; i <= nagEnd-1 ; ++i) r2 *= A[i];
        r1 = r1>r2?r1:r2;
        r2 = 1;
        for(int i = nagEnd+1 ; i < n ; ++i) r2 *= A[i];
        r1 = r1>r2?r1:r2;
        return r1;
    }
};

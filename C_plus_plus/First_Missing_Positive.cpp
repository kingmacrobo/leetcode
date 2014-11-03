class Solution {
public:
    int firstMissingPositive(int A[], int n) {
        int nonePos = 0;
        for(int i = 0 ; i < n ; ++i)
            if(A[i]<=0) ++nonePos;
        int none = n-nonePos;
        for(int i = 0 ; i < n-nonePos ; ++i){
            if(A[i]<=0){
                while(A[none]<=0) ++none;
                A[i--] = A[none++];
                continue;
            }
            if(A[i]==i+1||A[i]>n-nonePos||A[A[i]-1]==A[i]) continue;
            int tmp = A[A[i]-1];
            A[A[i]-1] = A[i];
            A[i--] = tmp;
        }
        for(int i = 0 ; i < n-nonePos ; ++i)
            if(A[i]!=i+1) return i+1;
        return n-nonePos+1;
    }
};

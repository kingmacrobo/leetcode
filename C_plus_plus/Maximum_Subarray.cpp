class Solution {
public:
    int maxSubArray(int A[], int n) {
        if(n==0) return 0;
        int max = A[0], sum = A[0];
        for(int i = 1; i < n ; ++i){
            if(A[i]<=0&&max<sum) max = sum;
            sum = A[i]>sum+A[i]?A[i]:sum+A[i];
        }
        if(max<sum) max = sum;
        return max;
    }
};

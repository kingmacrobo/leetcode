class Solution {
public:
    void sortColors(int A[], int n) {
        int r = 0, w = 0, b = n-1,tmp;
        for(int i = 0 ; i < n ; ++i){
            if(w+r+n-1-b==n) break;
            if(A[i]==0) A[r++] = 0;
            else if(A[i]==2){
                tmp = A[b];
                A[b--] = 2;
                A[i--] = tmp; 
            }
            else if(A[i]==1) ++w;
        }
        for(int i = r ; i <= b ; ++i)
            A[i] = 1;
    }
};

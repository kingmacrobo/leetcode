class Solution {
public:
    void merge(int A[], int m, int B[], int n) {
        for(int i = m-1 ; i >= 0 ; --i)
            A[n+i] = A[i];
        int i = 0, j = 0, k = 0;
        while(i < m && j < n){
            if(A[n+i] < B[j]) A[k++] = A[n+i++];
            else A[k++] = B[j++];
        }
        while(i<m) A[k++] = A[n+i++];
        while(j<n) A[k++] = B[j++];
    }
};

class Solution {
public:
    int removeDuplicates(int A[], int n) {
        if(n<3) return n;
        int current = A[0],count = 1,j=1;
        for(int i = 1 ; i < n ; ++i){
            if(A[i]==current){
                if(++count<3)
                    A[j++] = A[i];
            }
            else{
                A[j++] = A[i];
                current = A[i];
                count = 1;
            }
        }
        return j;
    }
};

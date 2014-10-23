class Solution {
public:
    int removeElement(int A[], int n, int elem) {
        int last = n-1;
        for(int i = 0 ; i <= last ; ++i){
            if(A[i] == elem){
                while(A[last]==elem&&last>i) --last;
                A[i] = A[last];
                --last;
            }
        }
        return last+1;
    }
};

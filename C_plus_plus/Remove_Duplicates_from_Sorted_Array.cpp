class Solution {
public:
    int removeDuplicates(int A[], int n) {
        if(n<=1) return n;
        int current = n-1,size = n;
        for(int i = n-2 ; i >= 0 ;--i){
            bool isDup = false;
            while(A[i]==A[current]&&i) {--i;isDup = true;}
            if(!i&&A[i]==A[current]) {--i;isDup = true;}
            for(int j = current+1,k = i+2 ; isDup && j < size ; ++j, ++k)
                A[k] = A[j];
            size = size - (current-i-1);
            current = i;
        }
        return size;
    }
};

class Solution {
public:
    int searchInsert(int A[], int n, int target) {
        int i = 0 , j = n-1;
        while(i<=j){
            if(target==A[(i+j)/2]) return (i+j)/2;
            if(target<A[(i+j)/2]) j = (i+j)/2-1;
            if(target>A[(i+j)/2]) i = (i+j)/2+1;
        }
        return i>j?i:j;
    }
};

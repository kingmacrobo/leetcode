class Solution {
public:
    bool searchMatrix(vector<vector<int> > &matrix, int target) {
        if(!matrix.size()||!matrix[0].size()) return false;
        int m = matrix.size() , n = matrix[0].size();
        int i = 0 , j = m*n-1 , k;
        while(i<=j){
            k = (i+j)/2;
            if(matrix[k/n][k%n]==target) return true;
            if(target>matrix[k/n][k%n]) i = k + 1;
            else j = k - 1;
        }
        return false;
    }
};

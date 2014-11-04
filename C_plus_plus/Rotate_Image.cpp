class Solution {
public:
    void rotate(vector<vector<int> > &matrix) {
        int n =matrix.size();
        for(int i = 0 ; i < n/2 ; ++i)
            for(int j = 0 ; j < (n+1)/2 ; ++j){
                int temp1 = matrix[i][j],temp2, x = i , y = j;
                for(int k = 0 ; k < 4 ; ++k){
                    temp2 = matrix[y][n-1-x];
                    matrix[y][n-1-x] = temp1;
                    temp1 = temp2;
                    int tt = x;
                    x = y;
                    y = n-1-tt;
                }
            }
    }
};

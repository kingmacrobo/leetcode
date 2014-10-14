class Solution {
public:
    vector<int> getRow(int rowIndex) {
        vector<int> result(rowIndex+1,1);
        int last = 1;
        for(int i = 2 ; i <= rowIndex+1 ; ++i)
            for(int j = 1 ; j < i-1 ; ++j){
                int temp = result[j];
                result[j] += last;
                last = temp;
            }
        return result;
    }
};

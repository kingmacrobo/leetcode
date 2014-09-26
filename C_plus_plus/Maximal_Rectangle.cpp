#include <iostream>
#include <vector>
#include <stack>
using namespace std;

class Solution {
public:
    int maximalRectangle(vector<vector<char>> &matrix) {
        int y = matrix.size();
        if(y==0)
            return 0;
        int x = matrix[0].size();
        int max = 0;
        vector<int> t(x,0);
        vector<vector<int>> b(y,t);
        for(int i = 0; i < x; ++i){
            int sum = 0;
            for(int j = 0; j < y; ++j){
                if(matrix[j][i]=='0')
                    sum = 0;
                else
                    sum += 1;
                b[j][i] = sum;
            }
        }
        for(int i = 0 ; i < y; ++i){
            int temp = maxRactangleHistogram(b[i]);
            if(temp > max)
                max = temp;
        }
        return max;
    }
    
    int maxRactangleHistogram(vector<int> &height){
        int max = 0;
        stack<int> s;
        int i =0;
        height.push_back(0);
        while(i<height.size()){
            if(s.empty()||height[i]>=height[s.top()])
                s.push(i++);
            else{
                int j = s.top();
                s.pop();
                int temp = height[j]*(s.empty()?i:i-s.top()-1);
                if(max < temp)
                    max = temp;
            }
        }
        return max;
    }
};

int main()
{
    vector<vector<char>> a =   {{'1','1','0','1','1'},
                                {'0','0','0','1','1'},
                                {'1','1','1','1','1'},
                                {'0','1','0','1','1'},
                                {'1','1','1','1','1'}};
    Solution st;
    cout << st.maximalRectangle(a);
    return 0;
}
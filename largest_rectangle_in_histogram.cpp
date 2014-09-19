#include <iostream>
#include <vector>
#include <stack>
using namespace std;

class Solution {
public:
    int largestRectangleArea(vector<int> &height) {
        stack<int> s;
        int max = 0,i = 0,temp,n = height.size()+1;
        height.push_back(0);
        while(i<n){
            if(s.empty()||height[i]>=height[s.top()])
                s.push(i++);
            else{
                int j = s.top();
                s.pop();
                temp = s.empty()?height[j]*i:height[j]*(i-s.top()-1);
                if(temp > max)
                    max = temp;
            }
        }
        return max;
    }
};

int main()
{
    vector<int> a = {2,1,2};
    Solution st;
    cout << st.largestRectangleArea(a);
    return 0;
}
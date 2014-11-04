class Solution {
public:
    int maxArea(vector<int> &height) {
        int max = 0;
        int i = 0, j = height.size()-1;
        while(i<j){
            int area = (height[i]<height[j]?height[i]:height[j])*(j-i);
            if(max < area) max = area;
            if(height[i]<height[j]){
                int k = i++;
                while(i<j&&height[i]<=height[k]) ++i;
            }
            else{
                int k = j--;
                while(i<j&&height[j]<=height[k]) --j;
            }
        }
        return max;
    }
};

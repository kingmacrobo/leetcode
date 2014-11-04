class Solution {
public:
    int maxArea(vector<int> &height) {
        int max = 0;
        int i = 0, j = height.size()-1;
        while(i<j){
            int area = (height[i]<height[j]?height[i]:height[j])*(j-i);
            if(max < area) max = area;
            if(height[i]<height[j]){
                int k = i+1;
                while(k<j){
                    if(height[k]>height[i])
                        break;
                    ++k;
                }
                if(k>=j) break;
                i = k;
            }
            else{
                int k = j-1;
                while(k>i){
                    if(height[k]>height[j])
                        break;
                    --k;
                }
                if(k<=i) break;
                j = k;
            }
        }
        return max;
    }
};

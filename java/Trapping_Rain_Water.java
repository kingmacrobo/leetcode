// Two point method , just scan once
// time O(n), space O(1)

public class Solution {
    public int trap(int[] height) {
        int result = 0, l = 0 , r = height.length - 1, lastHeight = 0;
        while(l <= r) {
            int min = height[l] < height[r] ? height[l] : height[r];
            if (min > lastHeight) {
                result += (r-l+1)*(min-lastHeight);
                lastHeight = min;
            }
            if (height[l] < height[r]) result -= height[l++];
            else result -= height[r--];
        }
        return result;
    }
}

// we can simplified the code like this, just for fun !
public class Solution {
    public int trap(int[] height) {
        int result = 0, l = 0 , r = height.length - 1, lastHeight = 0;
        while(l <= r) {
            int min = height[l] < height[r] ? height[l] : height[r];
            if (min > lastHeight) result += (r-l+1)*(min-lastHeight + ((lastHeight = min) - min));
            result = height[l] < height[r] ? (result -= height[l++]) : (result -= height[r--]); 
        }
        return result;
    }
}

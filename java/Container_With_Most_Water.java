// use two point strategy, search from two side.
// i,j represent the left point and right point.
// first we calculate the area by (i,j), and compare with the max, if > max , update max.
// if height[i] < height[j], right move i, or left move j, and then continue the above operation until i=j.
// time is O(n), space is O(1)
public class Solution {
    public int maxArea(int[] height) {
        int max = 0, i = 0, j = height.length -1 ;
        while (i < j) {
            boolean cmp = height[i] < height[j] ;
            int low = cmp ? height[i] : height[j] ;
            if (low*(j-i) > max ) max = low*(j-i) ;
            if (cmp) ++i ;
            else --j ;
        }
        return max ;
    }
}

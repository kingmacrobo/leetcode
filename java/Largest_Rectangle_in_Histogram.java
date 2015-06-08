// TLE solution
// search in two direction at every point
// Time is O(n^2), space is O(1).

public class Solution {
    public int largestRectangleArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; ++i) {
            int hei = height[i];
            int j = i-1, k = i + 1;
            while (j >= 0 && height[j] >= height[i]) 
                --j;
            while (k < height.length && height[k] >= height[i])
                ++k;
            int are = height[i] * (k-j+1-2);
            if (are > max) max = are;
        }
        return max;
    }
}

// Using stack
// Search from begin to end, and from end to begin
// If the current val is great than the peak of stack, add the location to the stack, or calculate the points greater 
// than the current point in the stack, and then , push the current point to the stack.
// Time is O(n), space is O(n)

public class Solution {
    public int largestRectangleArea(int[] height) {
        int max = 0;
        int[] Lmax = new int[height.length];
        int[] Rmax = new int[height.length];
        Stack<Integer> Lstack = new Stack<Integer>();
        Stack<Integer> Rstack = new Stack<Integer>();
        
        for (int i = 0; i < height.length; ++i) {
            if (Lstack.empty()) {
                Lstack.push(i);
                continue;
            }
            int index = Lstack.peek();
            if (height[i] >= height[index]) {
                Lstack.push(i);
            }
            else {
                index = Lstack.pop();
                Lmax[index] = height[index];
                while (!Lstack.empty() && height[Lstack.peek()] > height[i]) {
                    int k = Lstack.pop();
                    Lmax[k] = height[k] * (index - k + 1);
                }
                Lstack.push(i);
            }
        }
        if (!Lstack.empty()) {
            int index = Lstack.pop();
            Lmax[index] = height[index];
            while (!Lstack.empty()) {
                int k = Lstack.pop();
                Lmax[k] = height[k] * (index - k + 1);
            }
        }
        
        for (int i = height.length-1; i >= 0; --i) {
            if (Rstack.empty()) {
                Rstack.push(i);
                continue;
            }
            int index = Rstack.peek();
            if (height[i] >= height[index]) Rstack.push(i);
            else {
                index = Rstack.pop();
                Rmax[index] = height[index];
                while (!Rstack.empty() && height[Rstack.peek()] > height[i]) {
                    int k = Rstack.pop();
                    Rmax[k] = height[k] * (k - index + 1);
                }
                Rstack.push(i);
            }
        }
        if (!Rstack.empty()) {
            int index = Rstack.pop();
            Rmax[index] = height[index];
            while (!Rstack.empty()) {
                int k = Rstack.pop();
                Rmax[k] = height[k] * (k - index + 1);
            }
        }
        
        for (int i = 0; i < height.length; ++i) {
            int area = Rmax[i] + Lmax[i] - height[i];
            if (area > max) max = area;
        }
        return max;
    }
}

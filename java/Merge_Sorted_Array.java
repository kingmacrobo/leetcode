// Fill the number at the end of the array
// time is O(n), space is O(1).

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int a = m-1, b = n-1;
        for (int i = m+n-1; i >= 0; --i) {
            if (b < 0 || a >=0 && nums1[a] >= nums2[b])
                nums1[i] = nums1[a--];
            else nums1[i] = nums2[b--];
        }
    }
}

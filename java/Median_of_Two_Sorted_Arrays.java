// Using the "find the kth element of two sorted arrays"'s method
// In each subproblem, we just find the k/2th elements in two arrays, and compare them
// and drop the smaller part, which creats the new subproblem. Edge details can be see in my code.
// The method of kth element of two sorted arrays costs O(logk) time , and O(1) space.
// So the median is the (m+n)/2th element, the time complexity is O(log(n+m)).

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        if ((n+m)%2 == 0) {
            double m1 = findkth(nums1,nums2,0,n-1,0,m-1,(n+m)/2);
            double m2 = findkth(nums1,nums2,0,n-1,0,m-1,(n+m)/2+1);
            return (m1+m2)/2;
        }
        else
            return findkth(nums1,nums2,0,n-1,0,m-1,(n+m)/2+1);
    }
    public double findkth(int[] nums1, int[] nums2, int a1, int b1, int a2, int b2, int k) {
        if (a1 > b1) return nums2[a2+k-1];
        if (a2 > b2) return nums1[a1+k-1];
        if (k == 1) return Math.min(nums1[a1],nums2[a2]);
        int m = k/2;
        int offset1 = Math.min(b1-a1+1,m);
        int offset2 = Math.min(b2-a2+1,m);
        if (nums1[a1+offset1-1] == nums2[a2+offset2-1]) {
            if (k - offset1-offset2 == 0)
                return nums1[a1+offset1-1];
            else
                return findkth(nums1,nums2,a1+offset1,b1,a2+offset2,b2,k - offset1-offset2);
        }
        else if (nums1[a1+offset1-1] < nums2[a2+offset2-1])
            return findkth(nums1,nums2,a1+offset1,b1,a2,b2,k-offset1);
        else
            return findkth(nums1,nums2,a1,b1,a2+offset2,b2,k-offset2);
    }
}

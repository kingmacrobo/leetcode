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

// Another solution:

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int k = nums1.length + nums2.length;
        double a = findKth(nums1, nums2, 0, 0, (k+1)/2);
        double b = findKth(nums1, nums2, 0, 0, k/2+1);
        return (a+b)/2;
    }
    
    public int findKth(int[] nums1, int[] nums2, int i, int j, int k) {
        if (i == nums1.length) return nums2[j+k-1];
        if (j == nums2.length) return nums1[i+k-1];
        if (k == 1) return Math.min(nums1[i],nums2[j]);
        int a = i+k/2-1, b = j+k/2-1;
        if (a >= nums1.length) {
            a = nums1.length-1;
            if (nums1[a] <= nums2[b]) {
                return nums2[j + k-(a-i+1)-1];
            }
            else return findKth(nums1, nums2, i, b+1, k-k/2);
        }
        else if (b >= nums2.length) {
            b = nums2.length-1;
            if (nums2[b] <= nums1[a]) {
                return nums1[i + k - (b-j+1)-1];
            }
            else return findKth(nums1, nums2, a+1, j, k- k/2);
        }
        else {
            if (nums1[a] == nums2[b]) {
                if (k%2 == 0) return nums1[a];
                else return findKth(nums1, nums2, a+1, b+1, k - 2*(k/2));
            }
            else if (nums1[a] < nums2[b]) return findKth(nums1, nums2, a+1, j, k - k/2);
            else return findKth(nums1, nums2, i, b+1, k - k/2);
        }
        
    }
}

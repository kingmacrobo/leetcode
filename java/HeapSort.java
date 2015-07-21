package algorithm;

public class HeapSort {
	public void heapSort(int[] nums) {
		int n = nums.length;
		fixHeap(nums,n);
		for (int i = n-1; i >= 1; --i) {		
			swap(nums,0,i);
			fixDownHeap(nums, 0, i);
		}	
	}
	
	public void fixHeap(int[] nums, int n) {
		for (int i = n/2-1; i >= 0; --i) {
			fixDownHeap(nums, i, n);
		}
	}
	
	public void fixDownHeap(int[] nums, int loc, int n) {
		int left = 2*loc+1, right = 2*loc+2, maxLoc = -1;
		if (left >= n) return;
		if (right >= n) maxLoc = left;
		else maxLoc = nums[left] < nums[right] ? left : right;
		if (nums[loc] <= nums[maxLoc]) return;
		swap(nums,loc,maxLoc);
		fixDownHeap(nums,maxLoc,n);
	}
	
	public void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
}

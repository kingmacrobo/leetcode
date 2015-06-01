// recursive method
// Directly locate the position by comparing k with i!
// Time complexity is O(n^2), space is O(n) since we used the recursive method.

public class Solution {
	public String getPermutation(int n, int k) {
		StringBuilder sb = new StringBuilder();
		List<Integer> nums = new LinkedList<Integer>();
		for (int i = 1; i <= n; ++i)
			nums.add(i);
		deal(nums, k, sb);
		return sb.toString();
	}

	public void deal(List<Integer> nums, int k, StringBuilder sb) {
		if (k == 1) {
			for (Integer in : nums)
				sb.append(in);
			return;
		}
		int mul = 1, i;
		for (i = 1; i <= nums.size(); ++i) {
			mul *= i;
			if (mul >= k)
				break;
		}
		int size = nums.size();
		for (int w = 0; w < size - i; ++w) {
			sb.append(nums.get(0));
			nums.remove(0);
		}
		if (mul == k) {
			for (int j = nums.size() - 1; j >= 0; --j)
				sb.append(nums.get(j));
			return;
		}
		mul /= i;
		int cur = k / mul;
		if (k % mul == 0) {
			sb.append(nums.get(cur-1));
			nums.remove(cur-1);
			for (int w = nums.size()-1; w >=0; --w)
				sb.append(nums.get(w));
			return;
		}
		sb.append(nums.get(cur));
		nums.remove(cur);
		deal(nums, k - cur * mul, sb);
	}
}

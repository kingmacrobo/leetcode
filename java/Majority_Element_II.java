// Boyer Moore Voting Algorithm.
// Using two candidates.
// Time is O(n), space is O(1).

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        int count1 = 0, count2 = 0, candidate1 = 0, candidate2 = 1;
        for (int a : nums) {
            if (candidate1 == a) count1++;
            else if (candidate2 == a) count2++;
            else if (count1 == 0) {
                candidate1 = a;
                count1 = 1;
            }
            else if (count2 == 0) {
                candidate2 = a;
                count2 = 1;
            }
            else {
                count1--;
                count2--;
            }
        }
        count1 = count2 = 0;
        for (int a : nums) {
            if (a == candidate1) count1++;
            else if (a == candidate2) count2++;
        }
        if (count1 > nums.length/3) result.add(candidate1);
        if (count2 > nums.length/3) result.add(candidate2);
        return result;
    }
}

// Iteration+Recurse Method
// We can find the permutations of n numbers from the permutations of n-1 numbers
// If all the numbers are unique, in other words, there is no duplicate, we can just put the nth number to each interval
// of the number, which is one of the permutation of the n-1 numbers, wo generate all the permutations of n numbers.
//
// However, what if it's allowed existing duplicated numbers?
// My method is that :
// Firstly, sort the array, which can make the duplicated numbers contiguous, so as to simple our process following.
// Secondly, use the method before to solve it, which is different from the previous way is that we should generate the combination
// of the duplicated numbers by insert them to a permutation from the k-1 results. The combination process is done by recurse.

// The time complexity is about O(n!) since we should find out all the permutations! Space is about O(n!*n).

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        Arrays.sort(nums);
        for (int i = 0 ; i < nums.length; ++i) {
            List<List<Integer>> temp = new ArrayList<List<Integer>>();
            int count = 1;
            int val = nums[i];
            while (i+1 < nums.length && nums[i] == nums[i+1]) {
                i++;
                count++;
            }
            for (int j = 0 ; j < result.size(); ++j) {
                List<Integer> item = result.get(j);
                List<List<Integer>> new_items = new ArrayList<List<Integer>>();
                ArrayList<Integer> list = new ArrayList<Integer>();
                generate(item.size(),0,count,new_items,list);
                for (int k = 0; k < new_items.size(); ++k) {
                    ArrayList<Integer> locs = (ArrayList)new_items.get(k);
                    List<Integer> one = new ArrayList<Integer>(item);
                    for (int w = locs.size()-1; w >= 0 ; --w) {
                        one.add(locs.get(w),val);
                    }
                    temp.add(one);
                }
            }
            result = temp;
        }
        return result;
    }
    public void generate(int len, int index, int count, List<List<Integer>> new_items, ArrayList<Integer> list) {
        for (int i = index; i <= len; ++i) {
            list.add(i);
            if (list.size() == count) {
                new_items.add((ArrayList)list.clone());
            }
            else {
                generate(len,i,count,new_items,list);
            }
            list.remove(list.size()-1);
        }
    }
}

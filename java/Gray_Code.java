// Generate the number bit by bit
// When we arrive at the new bit , we shoud reverse the pre list and make or operation of 1 << i to each number to generate the 
// new list.
// Time and space are both O(2^n).

public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(0);
        if (n == 0) return list;
        list.add(1);
        for (int i = 1; i < n; ++i) {
            int size = list.size();
            for (int j = size-1; j >= 0; --j)
                list.add(list.get(j) | 1 << i);
        }
        return list;
    }
}

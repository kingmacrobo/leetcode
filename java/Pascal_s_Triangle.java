// Straight forword solution
// node(i,j) = node(i-1,j-1) + node(i-1,j);
// Time and space are both O(n).

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 1; i <= numRows; ++i) {
            List<Integer> row = new ArrayList<Integer>();
            if (i == 1) {
                row.add(1);
                result.add(row);
                continue;
            }
            for (int j = 0; j < i; ++j) {
                if (j == 0) 
                    row.add(result.get(i-2).get(j));
                else if (j == i-1)
                    row.add(result.get(i-2).get(j-1));
                else
                    row.add(result.get(i-2).get(j-1)+result.get(i-2).get(j));
            }
            result.add(row);
        }
        return result;
    }
}

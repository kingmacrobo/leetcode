// ROll Arrays method to reduce the space complexity to O(n).
// Time is O(n^2), space is O(n).

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        int[] preRow = new int[rowIndex+1];
        int[] result = new int[rowIndex+1];
        for (int i = 1; i <= rowIndex+1; ++i) {
            if (i == 1) {
                preRow[0] = 1;
                continue;
            }
            for (int j = 0; j < i; ++j) {
                if (j == 0)
                    result[j] = preRow[j];
                else if (j == i-1)
                    result[j] = preRow[j-1];
                else
                    result[j] = preRow[j] + preRow[j-1];
            }
            int[] temp = preRow;
            preRow = result;
            result = temp;
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < rowIndex+1; ++i)
            list.add(preRow[i]);
        return list;
    }
}

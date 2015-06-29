// DP solution
// dp(i) represents the sub result of substring(i,end) of s.
// Time is O(n^2), not sure.


public class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        List<List<List<String>>> record = new ArrayList<List<List<String>>>();
        boolean[][] isPalin = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            record.add(null);
            isPalin[i][i] = true;
            int k = i-1, t = i+1;
            while (k >= 0 && t < n) {
                if (s.charAt(k) == s.charAt(t))
                    isPalin[k--][t++] = true;
                else break;
            }
            k = i;
            t = i+1;
            while (k >= 0 && t < n) {
                if (s.charAt(k) == s.charAt(t))
                    isPalin[k--][t++] = true;
                else break;
            }
        }

        return dp(s,0,record,isPalin);
    }
    public List<List<String>> dp(String s, int start, List<List<List<String>>> record, boolean[][] isPalin) {
        if (record.get(start) != null)
            return record.get(start);
        List<List<String>> result = new ArrayList<List<String>>();
        if (start == s.length()-1) {
            List<String> list = new ArrayList<String>();
            list.add(s.substring(start,s.length()));
            result.add(list);
            record.set(start,result);
            return result;
        }
       
        for (int i = start; i < s.length(); ++i) {
            if (isPalin[start][i]) {
                if (i == s.length()-1) {
                    List<String> new_list = new ArrayList<String>();
                    new_list.add(s.substring(start,i+1));
                    result.add(new_list);
                    continue;
                }
                List<List<String>> temp = dp(s,i+1,record,isPalin);
                for (List<String> l : temp) {
                    List<String> new_list = new ArrayList<String>(l);
                    new_list.add(0,s.substring(start,i+1));
                    result.add(new_list);
                }
            }
        }
        record.set(start,result);
        return result;
    }
}

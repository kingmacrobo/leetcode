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

// Other's concise dp solution :

public class Solution {
    public List<List<String>> partition(String s) {
    int len = s.length();
        List<List<String>>[] result = new List[len + 1];
        result[0] = new ArrayList<List<String>>();
        result[0].add(new ArrayList<String>());

        boolean[][] pair = new boolean[len][len];
        for(int i=0; i<s.length(); i++){
            result[i+1] = new ArrayList<List<String>>();
            char c = s.charAt(i);
            for(int j=0; j<=i; j++){
                if(j == i)
                    pair[j][i] = true;
                else{
                    if(s.charAt(j) != c)
                        continue;
                    if(j == i-1)
                        pair[j][i] = true;
                    else
                        pair[j][i] = pair[j+1][i-1];
                }
                if(pair[j][i]){
                    String str = s.substring(j, i+1);
                    for(List<String> r : result[j]){
                        List<String> ri = new ArrayList<String>(r);
                        ri.add(str);
                        result[i+1].add(ri);
                    }
                }
            }
        }

        return result[len];        
    }
}

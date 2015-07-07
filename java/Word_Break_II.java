// Dp solution.
// Using a table to record the subresult of substring (k,end).
// And find all the k's answer by dp.
// Then record[0] will be the answer.
// Time is O(n^2), space not sure!

public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        HashMap<Integer, List<String>> record = new HashMap<Integer, List<String>>();
        dp(0,s,record,wordDict);
        return  record.get(0) != null ? record.get(0) : new ArrayList<String>();
    }
    List<String> dp(int k, String s, HashMap<Integer, List<String>> record, Set<String> wordDict) {
        if (k == s.length()) {
            return new ArrayList<String>();
        }
        if (record.containsKey(k)) return record.get(k);
        List<String> result = new ArrayList<>();
        for (int i = k; i < s.length(); ++i) {
            String word = s.substring(k,i+1);
            if (wordDict.contains(word)) {
                List<String> sub = dp(i+1,s,record,wordDict);
                if (sub != null) {
                    if (sub.size() == 0) {
                        result.add(word);
                    }
                    else {
                        for (String ss : sub) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(word);
                            sb.append(" ");
                            sb.append(ss);
                            result.add(sb.toString());
                        }
                    }
                }
            }
        }
        result = result.size() == 0 ? null : result;
        record.put(k, result);
        return result;
    }
}

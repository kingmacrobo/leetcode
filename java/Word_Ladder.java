// BFS soluton
// Time is O(n), space is O(n);

public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        Queue<String> que = new LinkedList<String>();
        wordDict.add(beginWord);
        wordDict.add(endWord);
        int ret = 1;
        que.offer(beginWord);
        wordDict.remove(beginWord);
        while (que.peek() != null) {
            ret++;
            for (int n = que.size(); n >= 1; --n) {
                String s = que.poll();
                StringBuilder sb = new StringBuilder(s);
                for (int i = 0; i < s.length(); ++i) {
                    char pre = s.charAt(i);
                    for (char c = 'a'; c <= 'z'; ++c) {
                        if (c == pre ) continue;
                        sb.setCharAt(i,c);
                        String ss = sb.toString();
                        if (wordDict.contains(ss)) {
                            if (ss.equals(endWord)) 
                                return ret;
                            que.offer(ss);
                            wordDict.remove(ss);
                        }
                    }
                    sb.setCharAt(i,pre);
                }
            }
        }
        return 0;
    }
}

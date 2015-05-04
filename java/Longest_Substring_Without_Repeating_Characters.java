public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> hash = new HashMap<Character,Integer>();
        int max = 0, start = 0;
        for (int i = 0 ; i < s.length() ; ++i){
            if(hash.containsKey(s.charAt(i)) && start <= hash.get(s.charAt(i))) {
                if (i - start > max)
                    max = i - start;
                start = hash.get(s.charAt(i)) + 1;
            }
            hash.put(s.charAt(i),i) ;
        }
        if (s.length() - start > max) 
            max = s.length() -start;
        return max;
    }
}

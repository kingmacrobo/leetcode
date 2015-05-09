// compare strs[1~n-1] with strs[0]
// time is O(mn), where m is the average length of strs and n is the String[] length. 
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length==0) return "";
        if (strs.length==1) return strs[0] ;
        String target = strs[0];
        int i = 0;
        for (; i < target.length() ; ++i) {
            for (int j = 1 ; j < strs.length ; ++j) {
                if (strs[j].length() <= i || strs[j].charAt(i) != target.charAt(i))
                    return target.substring(0,i);
            }
        }
        return target;
    }
}

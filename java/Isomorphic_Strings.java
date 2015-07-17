// HashMap solution.
// Using two hashmaps to key the same character map to the same one, once we find a map can't accrod to the hashmap, return false.
// Time is O(n), space is O(26).

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> table1 = new HashMap<Character, Character>();
        HashMap<Character, Character> table2 = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); ++i) {
            if (table1.containsKey(t.charAt(i))) {
                if (table1.get(t.charAt(i)) != s.charAt(i))
                    return false;
            }
            else
                table1.put(t.charAt(i), s.charAt(i));
            if (table2.containsKey(s.charAt(i))) {
                if (table2.get(s.charAt(i)) != t.charAt(i))
                    return false;
            }
            else 
                table2.put(s.charAt(i), t.charAt(i));
        }
        return true;
    }
}

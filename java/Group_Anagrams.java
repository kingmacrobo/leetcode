// Sort + HashMap
// First sort each string, and make the (String, List<String>) hashmap to get the anagram list groups.
// And then sort each group to make the sequence by lexicographic.
// Time is O(hlogh * nlogn), space is O(nh).

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> table = new HashMap<String, List<String>>();
        List<List<String>> result = new ArrayList<List<String>>();
        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String a = new String(c);
            if (!table.containsKey(a)) {
                List<String> list = new ArrayList<String>();
                result.add(list);
                table.put(a, list);
            }
            table.get(a).add(s);
        }
        for (List<String> list : result) {
            Collections.sort(list);
        }
        return result;
    }
}

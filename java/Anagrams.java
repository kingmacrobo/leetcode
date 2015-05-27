// Hashmap
// We should preprocess the strs by hashmap and string compress to make them like this: 
//        good => 1d1g2o
// The time of Above is O(nm), where n is the length of the array of strs and m is the average length of str.
// And then, we can use a HashMap<String,Integer> to hash the processed str and find out all the same processed strs, meanwhile we
// put the corresponding original str to the result list.
// The time of the postprossed if just O(n)!
// So, the whole time used is O(nm), space is O(nm).

public class Solution {
	public List<String> anagrams(String[] strs) {
		int[][] table = new int[strs.length][26];
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < strs.length; ++i) {
			for (int j = 0; j < 26; ++j)
				table[i][j] = 0;
		}
		String[] ss = new String[strs.length];
		for (int i = 0; i < strs.length; ++i) {
			for (int j = 0; j < strs[i].length(); ++j) {
				table[i][strs[i].charAt(j) - 'a']++;
			}
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < 26; ++j) {
				if (table[i][j] != 0) {
					sb.append(table[i][j] +""+ (char) ('a' + j));
				}
			}
			ss[i] = sb.toString();
		}
		HashMap<String, Integer> hash = new HashMap<String, Integer>();
		for (int i = 0; i < ss.length; ++i) {
			if (hash.containsKey(ss[i])) {
				int index = hash.get(ss[i]);
				if (index != -1)
					result.add(strs[index]);
				result.add(strs[i]);
				hash.put(ss[i], -1);
			} else {
				hash.put(ss[i], i);
			}
		}
		return result;
	}
}

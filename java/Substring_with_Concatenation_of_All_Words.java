// this is a hard problem
// we should using some methods to make it more efficient:
// 1. using hash to match the substring
// 2. add break conditions that make the process break from the impossible cases earlier.
//    like : If the remain string length is less than the total length of the words, we break it.
//           If we find a impossible localtion, starting from which it is impossible to come out a result, we
//           can let it in the impossible record, so that we come to it next time, we can know that it's impossible 
//           to get a answer, so we can break it earlier.
// The time is O(n^2), space is O(n) and the hashmap size.
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        int length = words.length;
        boolean[] record = new boolean[s.length()];
        if (length == 0) return result;
        HashMap<String,Integer> table = new HashMap<String,Integer>();
        int[] exist = new int[length];
        int[] target = new int[length];
        int count = 0, len = words[0].length();
        for (int i = 0 ; i < length ; ++i) {
            if (table.containsKey(words[i])) {
                target[table.get(words[i])]++;
            }
            else {
                table.put(words[i],i);
                target[i] = 1;
            }
        }
        for (int i = 0 ; s.length() - i >= len*length ; ++i) {
            if (record[i]) continue;
            resetEx(exist);
            count = 0;
            for (int j = i; j + len <= s.length() ; j += len) {
                String temp = s.substring(j,j+len);
                if (table.containsKey(temp)) {
                    int index = table.get(temp);
                    if (exist[index] == target[index])
                        break;
                    exist[index]++;
                    if (++count == length) {
                        result.add(i);
                        break;
                    }
                }
                else {
                    while (j >= i) {
                        record[j] = true;
                        j -= len;
                    }
                    break;
                }
            }
        }
        return result;
    }
    public void resetEx(int[] exist) {
        for (int i = 0; i < exist.length; i++) {
			exist[i] = 0;
		}
    }
}

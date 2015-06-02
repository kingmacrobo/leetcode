// Very interesting!
// Using a len and count to record the current length and word counts, when len + new > maxWidth, we find a line answer, and output it.
// Time is O(n), Space is O(n).

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<String>();
        int len = 0, count = 0, start = 0;
        for (int i = 0; i < words.length; ++i) {
            if (len + words[i].length() + count > maxWidth) {
                StringBuilder sb = new StringBuilder();
                int blanks = maxWidth - len;
                if (count == 1) {
                    sb.append(words[start]);
                    for (int j = 0; j < blanks; ++j)
                        sb.append(' ');  
                }
                else {
                    int average = blanks / (count-1);
                    int more = blanks - average * (count-1); 
                    for (int j = 0; j < count-1; ++j) {
                        sb.append(words[start+j]);
                        for (int w = 0; w < average; ++w)
                            sb.append(' ');
                        if (j < more)
                            sb.append(' ');
                    }
                    sb.append(words[start+count-1]);
                }
                result.add(sb.toString());
                start = i;
                len = words[i].length();
                count = 1;   
                continue;       
            }
            len += words[i].length();
            count++;
        }
        if (count > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(words[start]);
            len = words[start].length();
            for (int i = 1; i < count; ++i) {
                sb.append(" " + words[start+i]);
                len += 1 + words[start+i].length(); 
            }
            for (int i = 0; i < maxWidth - len; ++i)
                sb.append(' ');
            result.add(sb.toString());
        }
        return result;
    }
}

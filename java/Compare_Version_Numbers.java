// Separate all the numbers in the two string , and compare one by one.
// The suffix 0 has no gain on the version.
// Time is O(n), space is O(1).

public class Solution {
    public int compareVersion(String version1, String version2) {
        int i = 0,j = 0;
        while (i < version1.length() && j < version2.length()) {
            int ii = i, jj = j;
            while (ii < version1.length() && version1.charAt(ii) != '.') {
                ++ii;
            }
            String val1 = version1.substring(i,ii);
            int a = Integer.parseInt(val1);
            while (jj < version2.length() && version2.charAt(jj) != '.') {
                ++jj;
            }
            String val2 = version2.substring(j,jj);
            int b = Integer.parseInt(val2);
            if (a != b) {
                return a > b ? 1 : -1;
            }
            i = ii < version1.length() ? ii+1: ii;
            j = jj < version2.length() ? jj+1: jj;
        }
        if (i == version1.length() && j == version2.length())
            return 0;
        if (i == version1.length()) {
            int k = j;
            while (k < version2.length()) {
                if (version2.charAt(k) != '0' && version2.charAt(k) != '.')
                    return -1;
                ++k;
            }
            return 0;
        }
        int w = i;
        while (w < version1.length()) {
            if (version1.charAt(w) != '.' && version1.charAt(w) != '0')
                return 1;
            ++w;
        }
        return 0;
    }
    
}

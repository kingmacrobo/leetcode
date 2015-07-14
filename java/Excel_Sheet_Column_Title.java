// 26 denary
// Time todo, space is O(1).

public class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int remain = n % 26 == 0 ? 26 : n % 26;
            sb.insert(0,(char)('A'+ remain - 1));
            n = n/26;
            if (remain == 26) n--;
        }
        return sb.toString();
    }
}

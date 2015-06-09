// BackTracking method
// 0 can't be the prefix of the segment!

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        char[] ip = new char[15];
        generate(result, 4, s, 0, ip, 0);
        return result;
    }
    
    public void generate(List<String> result, int count, String s, int index, char[] ip, int loc) {
        if (count * 3 < s.length() - index || s.length() - index < count) 
            return;
        if (count == 0 && index == s.length()) {
            result.add(new String(ip,0,loc));
            return;
        }
        for (int i = 1; i <= 3 && index+i <= s.length(); ++i) {
            String seg = s.substring(index,index+i);
            int val = Integer.parseInt(seg);
            if (i == 2 && s.charAt(index)=='0')
                return;
            if (val <= 255) {
                int preloc = loc;
                if (count < 4) ip[loc++] = '.';
                for (int j = 0; j < i; ++j)
                    ip[loc++] = s.charAt(index+j);
                generate(result,count-1,s,index+i,ip,loc);
                loc = preloc;
            }
        }
    }
}

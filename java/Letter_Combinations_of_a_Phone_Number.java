// recurse method
// time is 3^n , space is 3^n
public class Solution {
    public List<String> letterCombinations(String digits) {
        String[][] table = {{""},{""},{"a","b","c"},{"d","e","f"},
                            {"g","h","i"},{"j","k","l"},{"m","n","o"},
                            {"p","q","r","s"},{"t","u","v"},{"w","x","y","z"}};
        if (digits.length()==0) return new ArrayList<String>();
        return dp(digits,0,table);
    }
    public List<String> dp(String digits, int i,String[][] table) {
        if (i == digits.length()) return Arrays.asList("");
        int index = digits.charAt(i) - '0';
        List<String> result = new ArrayList<String>();
        List<String> after = dp(digits,i+1,table);
        for (int j = 0 ; j < table[index].length ; ++j) {
            for (String s : after) {
                StringBuffer temp = new StringBuffer();
                temp.append(table[index][j]+s);
                result.add(temp.toString());
            }
        }
        return result;
    }
}

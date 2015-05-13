// we can also add a '(' to the sting end if the count of '(' is less than n
// we can only add a ')' if the ')' counts if less than '(', which makes the process generate
// parentheses correctly.
// Under the above rules, we can use rescure method to gennerate all the valid parentheses.
// time TODO.
public class Solution {
    public List<String> generateParenthesis(int n) {
        char[] pre = new char[2*n];
        List<String> result = new ArrayList<String>();
        deal(n,0,0,pre,result);
        return result;
    }
    public void deal(int n, int left, int right, char[] pre, List<String> result) {
        if (left == n && right == n) {
            result.add(String.valueOf(pre));
            return;
        }
        if (left < n) {
            pre[left+right] = '(';
            deal(n,left+1,right,pre,result);
        }
        if (right < left) {
            pre[left+right] = ')';
            deal(n,left,right+1,pre,result);
        }
    }
}

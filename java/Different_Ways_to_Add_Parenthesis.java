// Devide and Conque method!
// Time is O(n^2), space is O(n^2), not sure!

public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        return conque(input, 0, input.length()-1);
    }
    public List<Integer> conque(String input, int i, int j) {
        List<Integer> result = new ArrayList<Integer>();
        int w = i;
        while (w <= j && input.charAt(w) <= '9' && input.charAt(w) >= '0') ++w;
        if (w > j) {
            result.add(Integer.parseInt(input.substring(i,j+1)));
            return result;
        }
        for (int k = i; k <= j; ++k) {
            char c = input.charAt(k);
            if (c < '0' || c > '9') {
                List<Integer> a = conque(input, i, k-1);
                List<Integer> b = conque(input, k+1, j);
                for (Integer n : a)
                    for (Integer m : b) {
                        switch(c) {
                            case '+':
                                result.add(n+m);
                                break;
                            case '-':
                                result.add(n-m);
                                break;
                            case '*':
                                result.add(n*m);
                                break;
                        }
                    }
            }
        }
        return result;
    }
}

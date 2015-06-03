// Unix path
// We just record the valid words and raze the tail of the words list when come across "../"
// Finally we rebuild the path by add "/"+words[i] to the new Path.
// Time is O(n), Space is O(n)

public class Solution {
    public String simplifyPath(String path) {
        List<String> list = new LinkedList<String>();
        int i = 0;
        while (i < path.length()) {
            if (path.charAt(i) == '/') {
                i++;
                continue;
            }
            StringBuilder sb = new StringBuilder();
            while (i < path.length() && path.charAt(i) != '/') {
                sb.append(path.charAt(i++));
            }
            if (sb.length() == 1 && sb.charAt(0) == '.') continue;
            else if (sb.length() == 2 && sb.charAt(0) == '.' && sb.charAt(1) == '.') {       
                if (list.size() > 0) list.remove(list.size()-1);
            }
            else if (sb.length() != 0)
                list.add(sb.toString());
        }
        StringBuilder sb = new StringBuilder();
        for (String s : list) 
            sb.append('/' + s);
        if (list.size() == 0 && path.length() != 0)
            return new String("/");
        return sb.toString();
    }
}

// Other's method by using string.split
public String simplifyPath(String path) {
    List<String> stack = new LinkedList<>();
    for (String dir : path.split("/")) {
        if (dir.equals("..")) {
            if (stack.size() > 0) stack.remove(stack.size()-1);
        }
        else if (dir.length() > 0 && !dir.equals(".")) 
            stack.add(dir);
    }
    StringBuilder res = new StringBuilder();
    for (String dir : stack) res.append('/' + dir);
    return res.length() == 0 ? "/" : res.toString();
}

// TLE, don't know why.
// First, using bfs to creat the graph,
// Second, backtracking to generate the result.

public class Solution {
    List<List<String>> result = new ArrayList<List<String>>();
    HashMap<String, Queue<String>> fatherTable = new HashMap<String, Queue<String>>();
    LinkedList<String> list = new LinkedList<String>();
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        Queue<String> que = new LinkedList<String>();
        Set<String> pendingDelete = new HashSet<String>();
        dict.add(start);
        dict.add(end);
        que.offer(start);
        fatherTable.put(start, new LinkedList<String>());
        dict.remove(start);
        boolean find = false;
        while (que.peek() != null) {
            if (find == true) break;
            for (int n = que.size(); n >= 1; --n) {
                String s = que.poll();
                StringBuilder sb = new StringBuilder(s);
                for (int i = 0; i < s.length(); ++i) {
                    char pre = s.charAt(i);
                    for (char c = 'a'; c <= 'z'; ++c) {
                        if (c == pre ) continue;
                        sb.setCharAt(i,c);
                        String ss = sb.toString();
                        if (dict.contains(ss)) {
                            if (!find && ss.equals(end)) {
                                find = true;
                            }
                            if (!fatherTable.containsKey(ss)) {
                                fatherTable.put(ss,new LinkedList<String>());
                            }
                            fatherTable.get(ss).add(s);
                            if (!find) que.offer(ss);
                            pendingDelete.add(ss);
                        }
                    }
                    sb.setCharAt(i,pre);
                }
            }
            dict.removeAll(pendingDelete);
            pendingDelete.clear();
        }
        if (!find) return result;
        list.add(end);
        generate(end);
        return result;
    }
    
    public void generate(String end) {
        if (fatherTable.get(end).size() == 0) {
            result.add(new ArrayList<String>(list));
        }
        Queue<String> f = fatherTable.get(end);
        for (String s : f) {
            list.addFirst(s);
            generate(s);
            list.removeFirst();
        }
    }
}

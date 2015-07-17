// Grapgh, DFS, Judging cycle.
// Find whether this is a cycle in any part graph or not.
// Time is O(n), space is the size of HashMap.

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Cell> table = new HashMap<Integer, Cell>();
        for (int i = 0; i < prerequisites.length; ++i) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            if (!table.containsKey(a)) {
                table.put(a, new Cell());
            }
            table.get(a).neighbors.add(b);
        }
        int status = 0;
        for (Map.Entry<Integer, Cell> entry : table.entrySet()) {
            int key = entry.getKey();
            if (!dfs(key,table,status++))
                return false;
        }
        return true;
    }
    public boolean dfs(int key, HashMap<Integer, Cell> table, int status) {
        if (!table.containsKey(key)) return true;
        Cell c = table.get(key);
        if (c.status != -1 && c.status != status) return true;
        if (c.status == status) return false;
        c.status = status;
        for (Integer a : c.neighbors) {
            if (!dfs(a,table,status))
                return false;
        }
        return true;
    }
    class Cell {
        List<Integer> neighbors;
        int status;
        public Cell() {
            status = -1;
            neighbors = new ArrayList<Integer>();
        }
    }
}

// Topological Sort !
// Time is O(n^2), space is O(n^2).

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Arrays.fill(inDegree,0);
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) 
            graph.add(new ArrayList<Integer>());
        for (int i = 0; i < prerequisites.length; ++i) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            graph.get(a).add(b);
            inDegree[b]++;
        }
        for (int i = 0; i < numCourses; ++i) {
            int j = 0;
            for (; j < numCourses; ++j) {
                if (inDegree[j] == 0) break;
            }
            if (j == numCourses) return false;
            for (Integer k : graph.get(j))
                inDegree[k]--;
            inDegree[j] = -1;
        }
        return true;
    }
}

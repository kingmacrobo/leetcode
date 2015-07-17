// Topological Sort by BSF!
// Time is O(n), space is O(n^2).

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegrees = new int[numCourses];
        int[] result = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        Queue<Integer> que = new LinkedList<Integer>();
        Arrays.fill(inDegrees,0);
        for (int i = 0; i < numCourses; ++i)
            graph.add(new ArrayList<Integer>());
        for (int i = 0; i < prerequisites.length; ++i) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            graph.get(a).add(b);
            inDegrees[b]++;
        }
        for (int i = 0; i < numCourses; ++i)
            if (inDegrees[i] == 0) que.offer(i);
        for (int i = 0; i < numCourses; ++i) {
            if (que.peek() == null) return new int[]{};
            int j = que.poll();
            for (int k : graph.get(j)) {
                if (--inDegrees[k] == 0) que.offer(k);
            }
            result[numCourses-i-1] = j;
        }
        return result;
    }
}

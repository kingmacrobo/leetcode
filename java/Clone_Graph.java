// BFS + HashMap
// Firstly, using bfs to create all new node.
// And then, add neighbors to each node created via Hashmap.
// Time is O(n), space is O(n).

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        HashMap<UndirectedGraphNode, UndirectedGraphNode> table = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        Set<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
        Queue<UndirectedGraphNode> que = new LinkedList<UndirectedGraphNode>();
        que.offer(node);
        visited.add(node);
        table.put(node, new UndirectedGraphNode(node.label));
        while (que.peek() != null) {
            UndirectedGraphNode p = que.poll();
            for (UndirectedGraphNode n : p.neighbors) {
                if (! visited.contains(n)) {
                    table.put(n, new UndirectedGraphNode(n.label));
                    que.offer(n);
                    visited.add(n);
                }
            }
        }
        for (Map.Entry<UndirectedGraphNode, UndirectedGraphNode> entry : table.entrySet()) {
            for (UndirectedGraphNode n : entry.getKey().neighbors) {
                entry.getValue().neighbors.add(table.get(n));
            }
        }
        return table.get(node);
    }
}

// DFS soluiton :

public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        HashMap<UndirectedGraphNode, UndirectedGraphNode> visited = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        return node == null ? null : dfs(node, visited);
    }
    public UndirectedGraphNode dfs(UndirectedGraphNode node, HashMap<UndirectedGraphNode, UndirectedGraphNode> visited) {
        if (visited.containsKey(node)) return visited.get(node);
        UndirectedGraphNode n = new UndirectedGraphNode(node.label);
        visited.put(node,n);
        for (UndirectedGraphNode u : node.neighbors) {
            n.neighbors.add(dfs(u, visited));
        }
        return n;
    }
}

// Greedy Solution
// using crossed linkedlist
// Just one pass!
// Time is O(n), space is O(n).

public class Solution {
	    public String minWindow(String s, String t) {
	        int count = t.length(), start = -1, end = Integer.MAX_VALUE-1;
	        HashMap<Character,Node> table = new HashMap<Character,Node>();
	        Node head = null, tail = null;
	        for (int i = 0; i < t.length(); ++i) {
	            if (table.containsKey(t.charAt(i))) {
	                table.get(t.charAt(i)).count++;
	            }
	            else 
	                table.put(t.charAt(i),new Node(-1));
	        }
	        for (int i = 0; i < s.length(); ++i) {
	            char c = s.charAt(i);
	            if (table.containsKey(c)) {
	                Node node = table.get(c);
	                if (node.cur < node.count) {
	                    count--;
	                    node.cur++;
	                    if (node.head == null)
	                        node.tail = node.head = new Node(i);
	                    else {
	                        node.tail.l_next = new Node(i);
	                        node.tail = node.tail.l_next;
	                    }
	                    if (head == null)
	                        tail = head = node.tail;
	                    else {
	                        tail.next = node.tail;
	                        node.tail.pre = tail;
	                        tail = node.tail;
	                    }
	                }
	                else {
	                    if (node.head != tail) {
	                        if (head == node.head) {
	                            head = head.next;
	                            tail.next = node.head;
	                            node.head.pre = tail;
	                            tail = node.head;
	                        }
	                        else {
	                            node.head.pre.next = node.head.next;
	                            node.head.next.pre = node.head.pre;
	                            tail.next = node.head;
	                            node.head.pre = tail;
	                            tail = node.head;
	                        }
	                        if (node.head.l_next != null) {
	                            Node temp = node.head;
	                            node.head = node.head.l_next;
	                            node.tail.l_next = temp;
	                            node.tail = temp;
	                        }
	                    }
	                }
	                node.tail.loc = i;
	                if (count == 0 && (end - start > tail.loc - head.loc)) {
	                    start = head.loc;
	                    end = tail.loc;
	                }             
	            }
	        }
	        if (start == -1) return new String("");
	        return s.substring(start,end+1);
	    }
	    
	    class Node {
	        int loc, count;
	        int cur;
	        Node next, pre;
	        Node head,tail,l_pre,l_next;
	        public Node(int loc) {
	            this.loc = loc;
	            this.count = 1;
	            this.cur = 0;
	        }
	    }
}

// Another solution, Using Queue and HashMap
// Time O(n).

public class Solution {
    public String minWindow(String s, String t) {
        Node head = new Node(-1), tail = new Node(-1);
        head.after = tail;
        head.pre = tail.after = null;
        tail.pre = head;
        HashMap<Character, Integer> set = new HashMap<Character, Integer>();
        HashMap<Character, Queue<Node>> table = new HashMap<Character, Queue<Node>>();
        for (int i = 0; i < t.length(); ++i) {
            char c = t.charAt(i);
            if (!set.containsKey(c)) {
                set.put(c, 1);
            }
            else set.put(c, set.get(c)+1);
        }
        int count = 0, start = -1, end = -1;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (!set.containsKey(c)) continue;
            Node node = null;
            if (!table.containsKey(c)) {
                node = new Node(i);
                Queue<Node> que = new LinkedList<Node>();
                que.offer(node);
                table.put(c, que);
                count++;
            }
            else if (table.containsKey(c) && table.get(c).size() < set.get(c)) {
                node = new Node(i);
                table.get(c).offer(node);
                count++;
            }
            else {
                Queue<Node> que = table.get(c);
                node = que.poll();
                que.offer(node);
                node.index = i;
                node.pre.after = node.after;
                node.after.pre = node.pre;
            }
            tail.pre.after = node;
            node.pre = tail.pre;
            node.after = tail;
            tail.pre = node;
            if (count == t.length()) {
                int len = tail.pre.index - head.after.index + 1;
                if (start == -1 || end-start+1 > len) {
                    start = head.after.index;
                    end= tail.pre.index;
                }
            }
        }
        if (start != -1) {
            return s.substring(start, end+1);
        }
        return "";
    }
    
    class Node {
        int index;
        Node pre;
        Node after;
        public Node(int index) {
            this.index = index;
        }
    }
}

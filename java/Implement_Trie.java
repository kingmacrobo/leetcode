// HashMap! TRIE!
// Time of insert, search and findPrefix are all O(h) where h is the length of the word.
// Space is big!

class TrieNode {
    // Initialize your data structure here.
    HashMap<Character, TrieNode> table;
    Boolean isWord;
    public TrieNode() {
        table = new HashMap<Character, TrieNode>();
        isWord = false;
    }
    public void add(String word, int index) {
        if (index == word.length()) {
            isWord = true;
            return;
        }
        char c = word.charAt(index);
        if (!table.containsKey(c))
            table.put(c,new TrieNode());
        table.get(c).add(word,index+1);
    }
    public boolean findPrefix(String word, int index) {
        if (index == word.length()) return true;
        char c = word.charAt(index);
        if (!table.containsKey(c)) return false;
        return table.get(c).findPrefix(word,index+1);
    }
    public boolean search(String word, int index) {
        if (index == word.length()) return isWord;
        char c = word.charAt(index);
        if (!table.containsKey(c)) return false;
        return table.get(c).search(word,index+1);
    }
    
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        root.add(word, 0);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        return root.search(word, 0);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return root.findPrefix(prefix, 0);
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");

// Trie ! Hashmap!
// Create the trie tree. When deal with '.', we can should consider all edges!
// The time of add and search is O(h) where h is the word's length, space will be big cause we use hashmap!

public class WordDictionary {
    class TrieNode {
        HashMap<Character, TrieNode> table;
        boolean isWord;
        public TrieNode() {
            table = new HashMap<Character, TrieNode>();
            isWord = false;
        }
        public boolean find(String word, int index) {
            if (index == word.length()) return isWord;
            char c = word.charAt(index);
            if (c == '.') {
                for (Map.Entry<Character, TrieNode> entry : table.entrySet()) {
                    TrieNode node = entry.getValue();
                    if (node.find(word, index+1)) return true;
                }
                return false;
            }
            else {
                if (!table.containsKey(c)) return false;
                return table.get(c).find(word,index+1);
            }
        }
        public void add(String word, int index) {
            if (index == word.length()) {
                isWord = true;
                return;
            }
            char c = word.charAt(index);
            if (!table.containsKey(c))
                table.put(c,new TrieNode());
            table.get(c).add(word, index+1);
        }
    }
    
    TrieNode root = new TrieNode();
    // Adds a word into the data structure.
    public void addWord(String word) {
        root.add(word, 0);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return root.find(word, 0);
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");

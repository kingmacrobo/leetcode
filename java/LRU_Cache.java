// Using two hashtable, one is for couples of key and value, another is for the keys's location in lru arrays.
// When update the lru array, for example we last used key is a, we set -1 to a's loc in the array, and add one new a in the 
// end of the arrays, in the meantime, we update the lastIdx representing the oldest key.
// Time of get and set are both about O(n).
// Space is big I think.

public class LRUCache {
    HashMap<Integer, Integer> table;
    HashMap<Integer, Integer> locs;
    List<Integer> lru;
    int capacity, size, lastIdx;
    public LRUCache(int capacity) {
        table = new HashMap<Integer, Integer>();
        locs = new HashMap<Integer, Integer>();
        this.capacity = capacity;
        lru = new ArrayList<Integer>();
        lastIdx = size = 0;
    }
    
    public int get(int key) {
        if (!table.containsKey(key))
            return -1;
        updateLru(key);
        return table.get(key);
    }
    
    public void set(int key, int value) {
        if (table.containsKey(key)) {
            updateLru(key);
        }
        else if (size == capacity) {
            table.remove(lru.get(lastIdx));
            lru.add(key);
            locs.put(key,lru.size()-1);
            for (int i = lastIdx+1; i < lru.size(); ++i) {
                if (lru.get(i) != -1) {
                    lastIdx = i;
                    break;
                }
            }
        }
        else {
            lru.add(key);
            locs.put(key,lru.size()-1);
            size++;
        }
        table.put(key,value);
        
    }
    
    private void updateLru(int key) {
        int index = locs.get(key);
        lru.add(key);
        lru.set(index,-1);
        locs.put(key,lru.size()-1);
        for (int i = lastIdx; i < lru.size(); ++i) {
            if (lru.get(i) != -1) {
                lastIdx = i;
                break;
            }
        }
    }
}

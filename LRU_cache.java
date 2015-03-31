import java.util.LinkedHashMap;

public class Solution {
    int size;
    LinkedHashMap<Integer, Integer> cache;
    // @param capacity, an integer
    public Solution(int capacity) {
        size = capacity;
        cache = new LinkedHashMap<Integer, Integer>();
    }

    // @return an integer
    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        Integer val = cache.remove(key);
        cache.put(key, val);
        return val;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        if(cache.containsKey(key)){
            cache.remove(key);
            cache.put(key, value);
            return;
        }
        if(size== cache.size()){
            cache.remove(cache.entrySet().iterator().next().getKey());
        }
        cache.put(key, value);
    }
}

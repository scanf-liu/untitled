package leetCode_other._706_设计嘻哈映射;

public class MyHashMap {
    //boolean[] key;
    int[] value;
    /** Initialize your data structure here. */
    public MyHashMap() {
        //key = new boolean[1000001];
        value = new int[1000001];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        //this.key[key] = true;
        this.value[key] = value + 1;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return this.value[key]-1;
        //return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        this.value[key] = 0;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
/*
LFU Cache

Approach 1: Maintaining 2 HashMaps

Intuition:
We need to maintain all the kays, vals and frequencies. Without invalidation(Removing from the data strucutre when it reaches capacity), they can be maintained by a HashMap<Integer, Pair<Integer, Integer>> keyed by the original key and valued by the frequency - value pair.

With the invalidation, we need to maintan the current minimum frequency and delete particualr keys. Hence, we can group the keys with  the same frequency together and maintain another HashMap<Integer, Set>, keyed by the frequency and valued by the set of keys that have the same frequency, This way, if we know the minimum frequency, we can access the potential keys to be deleted.

Also note that int the case of a tie, we're required to find the least recently used keys and invalidate it, Hence we need to keep the frequencies ordered in the Set. Instead of using a TreeSet which adds an extra O(log(N)) time complexity we can maintain the keys using LinkedList so that it supports finding both an arbitrary key and the least recently used key in constant time. Fortunately LinkedHashSet can do the job. Once a key is inserted/updated, we put it to the end of the LinkedHashSet so that we can invalidate the first key in the LinkedHashSet corresponding to the minimum frequency.

The original operations can be transformed into operations on the 2 HashMaps, keeping them in sync and maintaining the minimum frequency. 

Since C++ Lacks LinkedHashSet, we have to use a workaround like maintaining a list of key and value pairs instead of the LinkedHashSet and keeping the iterator with the frequency in another unordered_map to keep this connection. The idea is similar but a little complecated. Another workaround would be to implement your own LRU cache with a doubly linked list.

Algorithm:

To make things simpler, assume we have 4 member variables:
1. Hashmap<Integer, Pair<Integer, Integer>> cache, keyed by the original key and valued by the frequency-value pair.
2. HashMap<Integer, LinkedListHashSet<Integer>> frequenncies, keyed by the frequenncy and valued by the set of keys that have the same frequency.
3. int minf, which is the minimum freqency at any given tiem.
4. int capacity, which is the capacity given in the input.

It's also convenient to have a private utility function insert to insert a key value pair with a given frequency.

void insert(int key, int frequency, int value)
1. Insert frequency-value pair into cache with the given key.
2. Get the LinkedHashSet corresponding to the given frequency (default to empty set) and insert the given key.

int get(int key)
1. If the given key is not in the cache, return -1, otherwise go to step 2.
2. Get the frequency and value from the cache.
3. Get the LinkedHashSet associated with frequency from frequencies and remvoe thhe given key form it, since the usage of the current  key is increased by the funciton call
4. If minf == frequency and the above LinkedHashSet is empty, that means there are no more elements used minf times, so increase minf by 1. To save some space, we can also delete the entry frequency from the frequencies hash map.
5. Call insert(key, frequency+1,value), since the current key's usage has increased from this function call.
6. Return value

void put(int key, int value)
1. if capacity<=0, exit
2. If the given key exists in cache, updated the value in the original frequency-value (don't call insert here) and then increment the frequency  by using the get(key). Exit the function.
3. If cache.size() == capacity, get the first (least recently used) value in the LinkedHashSet corresponding to minf in frequencies, and remove it from cache and the LinkedHashSet.
4. If we didn't exit the function in step 2, it means that this element is a new one, so the minimum frequency cannot possibly be greater than one. Set minf to 1.
5. Call insert(key, 1, value)


*/
class LFUCache {

    // Key: Original key, value: Frequency and original value.
    private Map<Integer, Pair<Integer, Integer>> cache;
    // Key: Frequency, value: all the keys that have same frequency.
    private Map<Integer, LinkedHashSet<Integer>> frequencies;
    private int minf;
    private int capacity;

    public LFUCache(int capacity) {
        cache = new HashMap<>();
        frequencies = new HashMap<>();
        minf = 0;
        this.capacity = capacity;
    }
    private void insert(int key, int frequency, int value) {
        cache.put(key, new Pair<>(frequency, value));
        frequencies.putIfAbsent(frequency, new LinkedHashSet<>());
        frequencies.get(frequency).add(key);
    }
    public int get(int key) {
        Pair<Integer, Integer> frequencyAndValue = cache.get(key);
        if(frequencyAndValue == null){
            return -1;
        }
        final int frequency = frequencyAndValue.getKey();
        final Set<Integer> keys = frequencies.get(frequency);
        keys.remove(key);
        if(keys.isEmpty()){
            frequencies.remove(frequency);
            if(minf==frequency){
                ++minf;
            }
        }
        final int value = frequencyAndValue.getValue();
        insert(key, frequency+1, value);
        return value;
    }
    
    public void put(int key, int value) {
        if(capacity<=0) return;
        Pair<Integer, Integer> frequencyAndValue = cache.get(key);
        if(frequencyAndValue!=null){
            cache.put(key, new Pair<>(frequencyAndValue.getKey(), value));
            get(key);
            return;
        }

        if(capacity == cache.size()){
            final Set<Integer> keys = frequencies.get(minf);
            final int keyToDelete = keys.iterator().next();
            cache.remove(keyToDelete);
            keys.remove(keyToDelete);
            if(keys.isEmpty()){
                frequencies.remove(minf);
            }
        }
        minf = 1;
        insert(key, 1, value);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
class RouterTLE {
    int size;
    Queue<int[]> pq;
    public RouterTLE(int memoryLimit) {
        size = memoryLimit;
        pq = new LinkedList<>();
        // ((a,b)->
        //     Integer.compare(a[2],b[2])
        // );
    }
    
    public boolean addPacket(int source, int destination, int timestamp) {
        int[] packet = new int[]{source, destination,timestamp};
        boolean exists = pq.stream().anyMatch(a -> java.util.Arrays.equals(a, packet));
        if (exists) return false;
        if(pq.size()>=size) pq.poll();
        pq.add(new int[]{source,destination,timestamp});
        return true;
    }
    
    public int[] forwardPacket() { 
        return pq.size()==0?new int[0]:pq.poll();
    }
    
    public int getCount(int destination, int startTime, int endTime) {
        int count = (int) pq.stream().filter(x ->x[1]==destination && x[2] >= startTime && x[2] <= endTime).count();
        return count;
    }
}
class Router {
    int size;
    Queue<int[]> pq;
    Set<String> packetSet;
    Map<Integer, TreeMap<Integer, Integer>> destToPrefix;

    public Router(int memoryLimit) {
        size = memoryLimit;
        pq = new LinkedList<>();
        packetSet = new HashSet<>();
        destToPrefix = new HashMap<>();
    }

    private void addToPrefix(int dest, int ts, int delta) {
        TreeMap<Integer, Integer> prefix = destToPrefix.computeIfAbsent(dest, k -> new TreeMap<>());
        int prev = prefix.isEmpty() ? 0 : prefix.lastEntry().getValue();
        // get cumulative count just before ts
        Integer floorKey = prefix.floorKey(ts);
        int base = floorKey == null ? 0 : prefix.get(floorKey);
        // new value at ts
        prefix.put(ts, base + delta);
        // fix higher keys
        for (var e = prefix.higherEntry(ts); e != null; e = prefix.higherEntry(e.getKey())) {
            prefix.put(e.getKey(), e.getValue() + delta);
        }
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        String key = source + "-" + destination + "-" + timestamp;
        if (packetSet.contains(key)) return false;

        if (pq.size() >= size) {
            int[] removed = pq.poll();
            String remKey = removed[0] + "-" + removed[1] + "-" + removed[2];
            packetSet.remove(remKey);
            addToPrefix(removed[1], removed[2], -1);
        }

        int[] packet = new int[]{source, destination, timestamp};
        pq.add(packet);
        packetSet.add(key);
        addToPrefix(destination, timestamp, +1);

        return true;
    }

    public int[] forwardPacket() {
        if (pq.isEmpty()) return new int[0];
        int[] removed = pq.poll();
        String remKey = removed[0] + "-" + removed[1] + "-" + removed[2];
        packetSet.remove(remKey);
        addToPrefix(removed[1], removed[2], -1);
        return removed;
    }

    public int getCount(int destination, int startTime, int endTime) {
        TreeMap<Integer, Integer> prefix = destToPrefix.get(destination);
        if (prefix == null) return 0;
        Integer endKey = prefix.floorKey(endTime);
        Integer startKey = prefix.floorKey(startTime - 1);
        int endSum = (endKey == null) ? 0 : prefix.get(endKey);
        int startSum = (startKey == null) ? 0 : prefix.get(startKey);
        return endSum - startSum;
    }
}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */
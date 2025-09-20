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
class Router500ms {
    int size;
    Queue<int[]> pq;
    Set<String> packetSet;
    Map<Integer, TreeMap<Integer, Integer>> destToPrefix;

    public Router500ms(int memoryLimit) {
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


class Router{
    private final int size;
    private final Map<Integer, List<Integer>> counts;
    private final Map<Long, int[]> packets;
    private final Queue<Long> queue;

    public Router(final int memoryLimit){
        this.size = memoryLimit;
        this.packets = new HashMap<>();
        this.counts = new HashMap<>();
        this.queue = new LinkedList<>();
    }
    public boolean addPacket(final int source, final int destination, final int timestamp){
        final long key = encode(source, destination,timestamp);
        if(packets.containsKey(key)) return false;
        if(packets.size()>=size) forwardPacket();
        packets.put(key, new int[]{source, destination, timestamp});
        queue.offer(key);
        counts.putIfAbsent(destination, new ArrayList<>());
        counts.get(destination).add(timestamp);
        return true;
    }
    public int[] forwardPacket(){
        if(packets.isEmpty()){
            return new int[] {};
        }
        final long key = queue.poll();
        final int[] packet = packets.remove(key);
        if(packet==null) return new int[]{};
        final int destination = packet[1];
        final List<Integer> list = counts.get(destination);
        list.remove(0);
        return packet;
    }
    public int getCount(final int destination, final int startTime, final int endTime){
        final List<Integer> list = counts.get(destination);
        if(list == null || list.isEmpty()) return 0;
        final int left = lowerBound(list, startTime);
        final int right = upperBound(list, endTime);
        return right-left;
    }
    private long encode(final int source, final int destination, final int timestamp){
        return ((long) source<<40 | (long) destination<<20)|timestamp;
    }
    private int lowerBound(final List<Integer> list, final int target){
        int low =0, high = list.size();
        while(low<high){
            final int mid = (low+high)>>>1;
            if(list.get(mid)<target) low = mid+1;
            else high = mid;
        }
        return low;
    }
    private int upperBound(final List<Integer> list, final int target){
        int low =0, high = list.size();
        while(low<high){
            final int mid = (low+high)>>>1;
            if(list.get(mid)<=target){
                low=mid+1;
            }else{
                high = mid;
            }
        }
        return low;
    }
}
/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */
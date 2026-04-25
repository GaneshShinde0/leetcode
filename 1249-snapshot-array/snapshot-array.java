class SnapshotArray {
    HashMap<Integer, TreeMap<Integer,Integer>> hashMap;
    int snapId;
    public SnapshotArray(int length) {
        this.hashMap = new HashMap<>();
        this.snapId = 0;
    }
    
    public void set(int index, int val) {
        TreeMap<Integer,Integer> tm =hashMap.computeIfAbsent(index,x->new TreeMap<Integer,Integer>());
        tm.put(snapId,val);
    }
    
    public int snap() {
        return snapId++;
    }
    
    public int get(int index, int snap_id) {
        TreeMap<Integer,Integer> tm =hashMap.computeIfAbsent(index,x->new TreeMap<Integer,Integer>());
        Map.Entry<Integer,Integer> e = tm.floorEntry(snap_id);
        if(e==null) return 0;
        return e.getValue();
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
class MapSum {

    HashMap<String, Integer> hm;
    Set<String> li;
    public MapSum() {
        hm = new HashMap<>();
        li = new HashSet<>();
    }
    
    public void insert(String key, int val) {
        hm.put(key,val);
        li.add(key);
    }
    
    public int sum(String prefix) {
        int sum = 0;
        // System.out.println(hm);
        for(String s: li){
            if(s.startsWith(prefix)){
                sum+=hm.get(s);
            }
        }
        return sum;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
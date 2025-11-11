class TimeMapInitial {
    TreeMap<String, String> tm;

    public TimeMapInitial() {
        tm = new TreeMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        tm.put(key+getFormattedTimeStamp(timestamp),value);
    }
    
    public String get(String key, int timestamp) {
        Map.Entry<String, String> e = tm.floorEntry(key+getFormattedTimeStamp(timestamp));
        if(e!=null && !e.getKey().startsWith(key)) return "";
        return e==null?"":e.getValue();
    }
    public String getFormattedTimeStamp(int timestamp){
        int n = String.valueOf(timestamp).length();
        StringBuilder sb = new StringBuilder(String.valueOf(timestamp));
        while(n<8){
            sb.insert(0,"0");
            n++;
        }
        return sb.toString();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */

 class TimeMap {
    private Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        Map.Entry<Integer, String> e = map.get(key).floorEntry(timestamp);
        return e == null ? "" : e.getValue();
    }
}

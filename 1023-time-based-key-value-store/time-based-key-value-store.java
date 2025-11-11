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

 class TimeMapUsingTreeMap {
    private Map<String, TreeMap<Integer, String>> map;

    public TimeMapUsingTreeMap() {
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
class TimeMap {

    static class Pair {
        int timestamp;
        String value;
        Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    private Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>())
           .add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        List<Pair> list = map.get(key);

        int lo = 0, hi = list.size() - 1;
        String res = "";
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (list.get(mid).timestamp <= timestamp) {
                res = list.get(mid).value;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return res;
    }
}

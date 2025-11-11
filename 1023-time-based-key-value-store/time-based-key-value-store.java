class TimeMap {
    TreeMap<String, String> tm;

    public TimeMap() {
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
        while(n<7){
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
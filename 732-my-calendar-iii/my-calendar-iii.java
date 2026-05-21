class MyCalendarThree {
    TreeMap<Integer,Integer> tm;
    public MyCalendarThree() {
        this.tm = new TreeMap<>();
    }
    
    public int book(int startTime, int endTime) {
        tm.put(startTime, tm.getOrDefault(startTime,0)+1);
        tm.put(endTime, tm.getOrDefault(endTime,0)-1);
        int res = 0, curr = 0;
        for(Map.Entry<Integer,Integer> e: tm.entrySet()){
            curr += e.getValue();
            res = Math.max(res, curr);
        }
        return res;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */
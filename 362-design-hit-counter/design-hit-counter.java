class HitCounter {

    private Deque<Integer> dq;
    public HitCounter() {
        dq = new ArrayDeque<>();
    }
    
    public void hit(int timestamp) {
        dq.add(timestamp);
    }
    
    public int getHits(int timestamp) {
        while(!dq.isEmpty() && dq.peekFirst()<=(timestamp-300)){
            dq.pollFirst();
        }
        return dq.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
class MovingAverage {
    private int size;
    private double mean;
    private Queue<Integer> q;
    public MovingAverage(int size) {
        this.size = size;
        this.mean=0; 
        q = new LinkedList<>();   
    }
    
    public double next(int val) {
        this.q.add(val);
        if(q.size()>this.size){
            int remove = q.poll();
            this.mean =(this.mean*this.size-remove+val)/this.size;
            return this.mean;
        }
        this.mean = ((this.mean*(this.q.size()-1))+val+0.0)/this.q.size();
        return this.mean;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
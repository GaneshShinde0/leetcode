class CustomStack {
    private int[] arr;
    private int idx=0;
    public CustomStack(int maxSize) {
        this.arr = new int[maxSize+1];
    }
    
    public void push(int x) {
        if(idx>=arr.length-1) return;
        arr[this.idx]=x;
        this.idx++;
    }
    
    public int pop() {
        if(idx==0) return -1;
        int temp = arr[idx-1];
        arr[idx]=0;
        this.idx--;
        return temp;
        
    }
    
    public void increment(int k, int val) {
        for(int i=0;i<Math.min(arr.length-1,k);i++){
            arr[i]+=val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */

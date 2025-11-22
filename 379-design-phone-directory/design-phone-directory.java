class PhoneDirectory {
                                                                                                                                                                          
    int[] arr;
    int i;
    TreeSet<Integer> released = new TreeSet<>();
    public PhoneDirectory(int maxNumbers) {
        this.arr = new int[maxNumbers];
        Arrays.fill(arr,-1);
        this.i=0;
    }
    public int get() {
        if(!released.isEmpty()){
            int temp = released.pollFirst();
            arr[temp] = temp;
            return temp;
        }else{
            int temp = i;
            i++;
            if(this.i>arr.length){
                return -1;
            }else{
                arr[temp]=temp;
                return temp;
            }
        }
    }
    
    public boolean check(int number) {
        return arr[number]==-1;
    }
    
    public void release(int number) {
        if(arr[number]!=-1){
            arr[number] = -1;
            released.add(number);
        }
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */
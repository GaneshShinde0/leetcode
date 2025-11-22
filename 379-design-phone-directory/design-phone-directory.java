class PhoneDirectoryInitial {
                                                                                                                                                                          
    int[] arr;
    int i;
    TreeSet<Integer> released = new TreeSet<>();
    public PhoneDirectoryInitial(int maxNumbers) {
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

 class PhoneDirectory {

    boolean[] used;
    int next;
    TreeSet<Integer> released = new TreeSet<>();

    public PhoneDirectory(int maxNumbers) {
        used = new boolean[maxNumbers];
        next = 0;
    }

    public int get() {
        if (!released.isEmpty()) {
            int num = released.pollFirst();
            used[num] = true;
            return num;
        }

        if (next >= used.length) return -1;

        used[next] = true;
        return next++;
    }

    public boolean check(int number) {
        return !used[number];
    }

    public void release(int number) {
        if (used[number]) {
            used[number] = false;
            released.add(number);
        }
    }
}

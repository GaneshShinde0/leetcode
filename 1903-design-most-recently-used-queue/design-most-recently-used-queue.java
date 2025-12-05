class MRUQueue {

    List<Integer> li;
    public MRUQueue(int n) {
        li = new ArrayList<Integer>();
        for(int i=1;i<=n;i++){
            li.add(i);
        }
    }
    
    public int fetch(int k) {
        int temp = li.remove(k-1);
        li.add(temp);
        return temp;
    }
}

/**
 * Your MRUQueue object will be instantiated and called as such:
 * MRUQueue obj = new MRUQueue(n);
 * int param_1 = obj.fetch(k);
 */
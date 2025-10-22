class TwoSum {
    HashMap<Integer,Integer> hm;
    public TwoSum() {
        this.hm = new HashMap<>();
    }
    
    public void add(int number) {
        this.hm.put(number, hm.getOrDefault(number,0)+1);
    }
    
    public boolean find(int value) {
        for(Map.Entry<Integer,Integer> e: hm.entrySet()){
            int i = e.getKey();
            if((value-i)==i && this.hm.containsKey(value-e.getKey()) && e.getValue()==1) continue;
            else if(this.hm.containsKey(value-e.getKey()) && e.getValue()>=1) return true;
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
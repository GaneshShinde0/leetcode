class RandomizedCollection {
    List<Integer> li;
    // LinkedHashSet guarantees O(1) hashSet does not
    HashMap<Integer,LinkedHashSet<Integer>> valToIdx;
    public RandomizedCollection() {
        this.li = new ArrayList<>();
        this.valToIdx = new HashMap<Integer, LinkedHashSet<Integer>>();
    }
    
    public boolean insert(int val) {
        valToIdx.computeIfAbsent(val, x->new LinkedHashSet<>()).add(li.size());
        li.add(val);
        return valToIdx.get(val).size()==1;
    }
    
    public boolean remove(int val) {
        if(!valToIdx.containsKey(val)) return false;
        
        int removeIdx = valToIdx.get(val).iterator().next();
        valToIdx.get(val).remove(removeIdx);

        int last = li.get(li.size()-1);
        li.set(removeIdx, last);

        valToIdx.get(last).add(removeIdx);
        valToIdx.get(last).remove(li.size()-1);
        li.remove(li.size()-1);
        
        if(valToIdx.get(val).size()==0) valToIdx.remove(val);

        return true;
    }
    
    public int getRandom() {
        int idx = (int) (Math.random()*li.size());
        return li.get(idx);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
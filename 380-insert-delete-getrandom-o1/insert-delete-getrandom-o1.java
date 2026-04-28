class RandomizedSet {

    List<Integer> li;
    Random random;
    HashMap<Integer, Integer> valToIdx;
    public RandomizedSet() {
        li = new ArrayList<>();
        random = new Random();
        valToIdx = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if(valToIdx.containsKey(val)){
            return false;
        }
        li.add(val);
        valToIdx.put(val,li.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!valToIdx.containsKey(val)){
            return false;
        }
        int idx = valToIdx.get(val);
        if(idx!=li.size()-1){
            int lastValue = li.get(li.size()-1);
            li.set(idx,lastValue);
            valToIdx.put(lastValue,idx);
        }
        valToIdx.remove(val);
        li.remove(li.size()-1);
        return true;
    }
    
    public int getRandom() {
        return li.get(random.nextInt(li.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
class FirstUnique {
    HashMap<Integer,Integer> hm = new HashMap<>();
    Set<Integer> set = new LinkedHashSet<>();

    public FirstUnique(int[] nums) {
        for(int num:nums){
            hm.put(num,hm.getOrDefault(num,0)+1);
            if(hm.get(num)>1 && set.contains(num)) set.remove(num);
            else if(hm.get(num)==1) set.add(num); 
        }    
    }
    
    public int showFirstUnique() {
        if(set.isEmpty()) return -1;
        // else return new ArrayList<>(set).get(0);// Changing this  line to next improves time from 2 second to 144 ms
        else return set.iterator().next();
    }
    
    public void add(int num) {
        hm.put(num,hm.getOrDefault(num,0)+1);
        if(hm.get(num)>1 && set.contains(num)) set.remove(num);
        else if(hm.get(num)==1) set.add(num); 
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
class Solution {
    public int[] onceTwice(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i:nums){
            hm.put(i, hm.getOrDefault(i,0)+1);
        }
        int[] res = new int[2];
        for(Map.Entry<Integer,Integer> e: hm.entrySet()){
            if(e.getValue()==1) res[0] = e.getKey();
            if(e.getValue()==2) res[1] = e.getKey();
        }
        return res;
    }
}
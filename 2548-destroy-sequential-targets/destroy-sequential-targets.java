class Solution {
    public int destroyTargets(int[] nums, int space) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int maxDestroyed = 0;
        for(int num:nums){
            int rem = num%space;
            hm.put(rem, hm.getOrDefault(rem,0)+1);
            maxDestroyed = Math.max(maxDestroyed, hm.get(rem));
        }
        int res = Integer.MAX_VALUE;
        for(int num:nums){
            int rem = num%space;
            if(hm.get(rem)==maxDestroyed && num<res){
                res=num;
            }
        }
        return res;
    }
}
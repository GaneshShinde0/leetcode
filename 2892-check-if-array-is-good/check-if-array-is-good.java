class Solution {
    public boolean isGood(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int num:nums) hm.put(num,hm.getOrDefault(num,0)+1);
        int size = hm.size();
        int temp = size+1;
        if(nums.length!=temp||hm.getOrDefault(size,0)!=2) return false;
        for(int i=1;i<size;i++){
            if(hm.getOrDefault(i,0)!=1) return false;
        }
        return true;

    }
}
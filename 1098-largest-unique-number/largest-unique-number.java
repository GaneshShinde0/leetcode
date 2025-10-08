class Solution {
    public int largestUniqueNumber(int[] nums) {
        Map<Integer,Integer> hm = new TreeMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        int res = -1;
        for(Map.Entry<Integer,Integer> e:hm.entrySet()){
            if(e.getValue()==1){
                res=e.getKey();
            }
        }
        return res;
    }
}
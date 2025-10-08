class Solution {
    public int largestUniqueNumber(int[] nums) {
        int result = -1;
        int[] map = new int[1001];
        for (int num : nums) {
            map[num]++;
        }
        for(int i=1000;i>=0;i--){
            if(map[i]==1) return i;
        }
        return result;
    }
    public int largestUniqueNumberUsingHashMap(int[] nums) {
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
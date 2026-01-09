class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        
        int left =0, right=0, n=nums.length,odds=0,res=0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);
        for(right=0;right<n;right++){
            if(nums[right]%2==1) odds++;
            if(hm.containsKey(odds-k)){
                res+=hm.get(odds-k);
            }
            hm.put(odds, hm.getOrDefault(odds,0)+1);
        }
        return res;
    }
}

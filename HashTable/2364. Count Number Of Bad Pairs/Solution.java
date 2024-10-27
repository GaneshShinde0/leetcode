class Solution {
    public long countBadPairsTimeLimitExceeded(int[] nums) {
        long res =0;
        int n = nums.length;
        for(int i=0;i<n-1;i++){
            int a = nums[i];
            for(int j=i+1;j<n;j++){
                if(j-i != nums[j]-a) res++;
            }
        }
        return res;
    }

    public long countBadPairs(int[] nums){
        int n = nums.length;
        long total = (long)  n*(n-1)/2;
        long good = 0;
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int temp = i-nums[i];
            int count =mp.getOrDefault(temp,0);
            good += count;
            mp.put(temp,count+1);
        }
        return total-good;
    }
}

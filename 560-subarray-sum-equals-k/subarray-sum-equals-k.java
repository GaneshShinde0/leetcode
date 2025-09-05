class Solution {
    public int subarraySumInitialSolution(int[] nums, int k) {
        int n = nums.length;
        if(n==1&&nums[0]!=k)return 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        int[] prefSum = new int[n];
        int curr =0;
        int res =0;
        for(int i=0;i<nums.length;i++){
            curr+=nums[i];
            prefSum[i]+=curr;
            if(hm.containsKey(prefSum[i]-k)) res++;
            if((prefSum[i]-k)==0)res++;
            hm.put(curr,i);
        }
        System.out.println(hm);
        return res;
    }


    public int subarraySumold(int[] nums, int k) {
        int total = 0;
        int res = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0,1);
        for(int n:nums){
            total+=n;
            if(hm.containsKey(total-k)){
                res+=hm.get(total-k);
            }
            hm.put(total, hm.getOrDefault(total,0)+1);
        }
        return res;
    }


    public int subarraySum(int[] nums, int k) {
        int res =0;
        int total = 0;
        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(0,1);
        for(int i:nums){
            total+=i;
            if(hm.containsKey(total-k)){
                res+=hm.get(total-k);
            }
            hm.put(total, hm.getOrDefault(total,0)+1);
        }
        return res;
    }
}
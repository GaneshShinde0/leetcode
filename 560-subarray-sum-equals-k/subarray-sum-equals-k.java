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

    public int subarraySum(int[] nums, int k){
        HashMap<Integer, Integer> subNum = new HashMap<>();
        subNum.put(0,1);
        int total = 0, count =0;
        for(int n:nums){
            total+=n;
            if(subNum.containsKey(total-k)){
                count+=subNum.get(total-k);
            }
            subNum.put(total,subNum.getOrDefault(total,0)+1);
        }
        return count;
    }
}
class Solution {
    public boolean checkSubarraySumFailsThreeTestCases(int[] nums, int k) {
        int currSum = 0;
        int n=nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            currSum+=nums[i];
            hm.putIfAbsent((k-currSum%k)%k,i);
            if(i>0 && currSum%k==0) return true;
            if((hm.containsKey(currSum%k)||nums[i]==0) &&(i-hm.getOrDefault(k-currSum%k,0))>=1) return true;
        }
        System.out.println(hm);
        return false;
    }

    
    public boolean checkSubarraySumMine(int[] nums, int k) {
        int currSum = 0;
        int n=nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1); // important: handles subarray starting at index 0
        for(int i=0;i<nums.length;i++){
            currSum+=nums[i];
            if(hm.containsKey((k-currSum%k)%k) && (i-hm.get((k-currSum%k)%k)>1)) return true;
            hm.putIfAbsent((k-currSum%k)%k,i);
        }
        // System.out.println(hm);
        return false;
    }

    public boolean checkSubarraySum(int[] nums, int k){
        int n = nums.length;
        int remainder = 0;
        int currSum=0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0,-1);// This will handle when array is starting from 0;
        for(int i=0;i<nums.length;i++){
            currSum+=nums[i];
            remainder = (k+currSum%k)%k;
            if(hm.containsKey(remainder) && i-hm.get(remainder)>=2)return true;
            hm.putIfAbsent(remainder,i);
        }
        return false;
    }
}
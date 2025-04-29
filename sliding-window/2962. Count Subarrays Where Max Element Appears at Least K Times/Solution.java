class Solution {
    public long countSubarraysSlidingWindow(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        for(int i:nums) max=Math.max(max,i);
        long ans = 0; int start = 0;
        int maxElementsInWindow = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i]==max) maxElementsInWindow++;
            while(maxElementsInWindow==k){
                if(nums[start]==max){
                    maxElementsInWindow--;
                }
                start++;
            }
            ans+=start;
        }
        return ans;
    }

   public long countSubarrays(int[] nums, int k){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++) max = Math.max(nums[i],max);
        ArrayList<Integer> indexOfMaxElements = new ArrayList<>();
        long ans = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==max) indexOfMaxElements.add(i);
            int freq = indexOfMaxElements.size();
            if(freq>=k){
                ans+=indexOfMaxElements.get(freq-k)+1;
            }
        }
        return ans;
   } 
}

class Solution {
    record Item(int value, int index){}
    public int[] maxValue(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Item[] maxFromLeft = new Item[n];
        Item prev = new Item(0,-1);
        for(int i=0;i<n;i++){
            if(nums[i]>prev.value()){
                prev = new Item(nums[i],i);
            }
            maxFromLeft[i] = prev;
        }
        process(n-1,Integer.MAX_VALUE,0,maxFromLeft, ans, nums);
        return ans;
    }
    private void process(int r, int rightMin, int rightMax, Item[] maxFromLeft, int[] ans, int[] nums){
        int prevMax = maxFromLeft[r].value();
        int pivotIdx = maxFromLeft[r].index();
        
        int currMax = prevMax<=rightMin?prevMax:rightMax;
        int nextRightMin = Math.min(prevMax, rightMin);
        for(int i=pivotIdx; i<=r;i++){
            ans[i] = currMax;
            nextRightMin = Math.min(nextRightMin, nums[i]);
        }
        if(pivotIdx==0) return;
        process(pivotIdx-1,nextRightMin, currMax, maxFromLeft, ans,nums);

    }
}
class Solution {
    public int firstMissingPositiveInitial(int[] nums) {
        // int min = Integer.MAX_VALUE, max=Integer.MIN_VALUE;
        int n = nums.length;
        int[] freq = new int[n+1];
        for(int i:nums){
            if(i<0 || i>n) continue;
            else freq[i]++;
        }
        for(int i=1;i<nums.length+1;i++){
            if(freq[i]==0) return i;
        }
        return n+1;
    }
    
    // Index as a Hash Key
    public int firstMissingPositiveIndexHashKey(int[] nums) {
        int n = nums.length;
        boolean contains1 = false;
        for(int i=0;i<n;i++){
            if(nums[i]==1) contains1 = true;
            if(nums[i]<=0||nums[i]>n){
                nums[i]=1;
            }
        }
        if(!contains1) return 1;
        for(int i=0;i<n;i++){
            int curr = Math.abs(nums[i]);
            if(curr==n) nums[0] = -Math.abs(nums[0]);
            else nums[curr] = -Math.abs(nums[curr]);
        }

        // First Positive in nums is smallest positive integer.
        // As we have set everything else to -ve;
        for(int i=1;i<n;i++){
            if(nums[i]>0) return i;
        }
        if(nums[0]>0) return n;
        return n+1;

    }
    // Approach 3: Cycle Sort
    public int firstMissingPositive(int[] nums){
        int n = nums.length;
        int i=0;
        while(i<n){
            int correctIdx = nums[i]-1;
            if(nums[i]>0 && nums[i]<=n && nums[i]!=nums[correctIdx]){
                swap(nums,i, correctIdx);
            }else{
                i++;
            }
        }

        for(i=0;i<n;i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return n+1;
    }

    private void swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1]=nums[index2];
        nums[index2] = temp;
    }
}
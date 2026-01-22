class Solution {
    public int minimumPairRemoval(int[] nums) {
        int count =0;
        int start =0, end = nums.length-1;
        while(start<end){
            boolean nonDecreasing = true;
            int minSum = Integer.MAX_VALUE;
            int minIndex = 0;
            for(int i=0;i<end;i++){
                if(nums[i]>nums[i+1]) nonDecreasing = false;
                if(nums[i]+nums[i+1]<minSum){
                    minSum = nums[i]+nums[i+1];
                    minIndex = i;
                }
            }
            
            if(nonDecreasing) break;
            nums[minIndex] = minSum;
            for(int i=minIndex+1;i<end;i++){
                nums[i]=nums[i+1];
            }
            end--;
            count++;
        }
        return count;
    }
}
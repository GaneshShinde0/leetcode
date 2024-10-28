class Solution {
    public void sortColorsInitial(int[] nums) {
        int[] col= new int[3];
        for(int i:nums){
            col[i]++;
        }
        int j=0;
        for(int i=0;i<3;i++){
            while(col[i]>0){
                nums[j]=i;
                j++;
                col[i]--;
            }
        }
    }
    public void sortColors(int[] nums) {
        int start = 0, end = nums.length-1;
        int curr = 0;
        while(curr<=end){
            if(nums[curr]==0){
                int temp = nums[start];
                nums[start]=nums[curr];
                nums[curr]=temp;  
                start++;
                curr++;
            } else if(nums[curr]==2){
                int temp = nums[curr];
                nums[curr] = nums[end];
                nums[end]= temp;
                end--;
            } else{
                curr++;
            }
        }
    }
}

class Solution {
    public int[] sortByAbsoluteValue(int[] nums) {
        int n = nums.length;
        int[][] numIdx = new int[n][2];
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                numIdx[i][0]-=nums[i];
                numIdx[i][1]=-1;
            }else{
                numIdx[i][0]=nums[i];
                numIdx[i][1]=1;
            }
        }

        Arrays.sort(numIdx,(a,b)->Integer.compare(a[0],b[0]));
        for(int i=0;i<nums.length;i++){
            nums[i]=numIdx[i][0]*numIdx[i][1];
        }
        return nums;
    }
}
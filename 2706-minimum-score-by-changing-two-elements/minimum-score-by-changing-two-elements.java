/*
[1,4,7,8,5]
[1,4,5,7,8]

current min = 1
current max = 7

result = 6

change  1 to 4

*/
class SolutionInitial {
    public int minimizeSum(int[] nums) {
        int n = nums.length;
        if(n==3) return 0;
        Arrays.sort(nums);
        int maxMin = Integer.MAX_VALUE;
        maxMin = Math.min(maxMin,Math.abs(nums[n-1]-nums[2]));
        maxMin = Math.min(maxMin,Math.abs(nums[n-2]-nums[1]));
        maxMin = Math.min(maxMin,Math.abs(nums[n-3]-nums[0]));
        return maxMin;
    }
}
class Solution {
    public int minimizeSum(int[] nums) {
       int max1=Integer.MIN_VALUE;
       int max2=Integer.MIN_VALUE;
       int max3=Integer.MIN_VALUE;
       int n=nums.length;
       for(int i=0;i<n;i++){
        if(nums[i]>max1){
            max3=max2;
            max2=max1;
            max1=nums[i];
        }
        else if(nums[i]>max2){
            max3=max2;
            max2=nums[i];
        }
        else if(nums[i]>max3) max3=nums[i];
       }
       int min1=Integer.MAX_VALUE;
       int min2=Integer.MAX_VALUE;
       int min3=Integer.MAX_VALUE;
       for(int i=0;i<n;i++){
        if(nums[i]<min1){
            min3=min2;
            min2=min1;
            min1=nums[i];
        }
        else if(nums[i]<min2){
            min3=min2;
            min2=nums[i];
        }
        else if(nums[i]<min3) min3=nums[i];
       }
       return Math.min(max3-min1,Math.min(max2-min2,max1-min3));

        
    }
}
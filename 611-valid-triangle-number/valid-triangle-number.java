class Solution {
    // Count Number of triplets such that sum of two numbers is greater than third
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                int sum = nums[i]+nums[j];
                for(int k=j+1;k<n;k++){
                    // System.out.println("nums[K]: "+nums[k]+", Sum: "+sum);

                    if(nums[k]<sum){
                        res++;
                    }else{
                        break;
                    }
                }
            }
        }
        return res;
    }
}
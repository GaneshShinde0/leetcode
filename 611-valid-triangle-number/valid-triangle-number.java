class Solution {
    // Count Number of triplets such that sum of two numbers is greater than third
    public int triangleNumberBruteForce(int[] nums) {
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

    private int binarySearch(int[] nums, int l, int r, int x){
        while(r>=l && r<nums.length){
            int mid = (l+r)/2;
            if(nums[mid]>=x){
                r = mid-1;
            }else{
                l= mid+1;
            }
        }
        return l;
    }
    public int triangleNumber(int[] nums){
        int count = 0;
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1 && nums[i]!=0;j++){
                int k = binarySearch(nums,j+1,n-1,nums[i]+nums[j]);
                count+=k-j-1;
            }
        }
        return count;
    }
}
class SolutionONTimeAndSpace {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int num:nums) set.add(num);
        int i = 1;
        while(set.contains(i*k)) i++;
        return i*k;
    }
}

class Solution{
    public int missingMultiple(int[] nums, int k){
        int n = nums.length;

        for(int i=0;i<n;i++){
            while(isValid(nums[i], k, n) && nums[nums[i]/k-1]!=nums[i]){
                int j = nums[i]/k-1;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        // Find first index where the expected multiple is mising.
        for(int i=0;i<n;i++){
            if(nums[i] != (long) (i+1)*k){
                return (i+1)*k;
            }
        }
        return (n+1)*k;
    }
    private boolean isValid(int val, int k, int n){
        return val>0 && val%k==0 && val/k<=n;
    }
}
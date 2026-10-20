class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        Set<Integer> factors = getFactors(n);
        int sum = 0;
        for(Integer factor:factors){
            if(isSortable(nums,factor)) sum+=factor;
        }
        return sum;
    }

    private boolean isSortable(int[] nums, int factor){
        Integer prevMax = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i+=factor){
            int currMax = Integer.MIN_VALUE;
            if(!check(nums,i,i+factor)) return false;
            for (int j = i; j < i+factor; j++) {
                if(nums[j]<prevMax) return false;
                currMax = Math.max(currMax, nums[j]);
            }
            prevMax = currMax;
        }
        return true;
    }
    public boolean check(int[] nums,int start, int end) {
        int count = 0;
        for (int i = start; i < end - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (++count > 1) return false;
            }
        }
        if (nums[end - 1] > nums[start]) count++;
        return count <= 1;
    }
    private Set<Integer> getFactors(int n){
        Set<Integer> factors = new HashSet<>();
        for(int i=1;i<=Math.sqrt(n);i++){
            if(n%i==0){
                factors.add(i);
                factors.add(n/i);
            }
        }
        return factors;
    }
}
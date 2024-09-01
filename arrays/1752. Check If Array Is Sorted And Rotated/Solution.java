class Solution {
    public boolean check(int[] nums) {
        int count= 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]>nums[i]) count++;
            if (count>=2) return false;
        }
        if(nums[nums.length-1]>nums[0] && count>=1) return false;
        return true;
    }
    public boolean check1(int[] nums) {
        int count = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                if (++count > 1) return false;
            }
        }
        return true;
    }
}

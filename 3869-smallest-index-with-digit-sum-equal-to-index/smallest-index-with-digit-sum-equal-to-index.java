class Solution {
    public int smallestIndex(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(i==sum(nums[i])) return i;
        }
        return -1;
    }
    private int sum(int num){
        int sum = 0;
        while(num>0){
            int rem = num%10;
            num = num/10;
            sum+=rem;
        }
        return sum;
    }
}
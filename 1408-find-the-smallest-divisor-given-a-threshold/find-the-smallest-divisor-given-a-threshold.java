class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        long sum =0;
        for(int i:nums) sum+=i;
        long low = 1,high = sum;
        while(low<high){
            long mid = low+(high-low)/2;
            long curr = calculateSumOfDivisors(nums,mid);
            if(curr>threshold){
                low = mid+1;
            }else{
                high=mid;
            }
        }
        return (int) high;
    }

    public long calculateSumOfDivisors(int[] nums, long mid){
        long sum = 0;
        for(int i:nums){
            sum+=(int) Math.ceil(i*1.0/mid);
        }
        return sum;
    }
}
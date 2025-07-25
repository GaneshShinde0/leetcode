class Solution {
    public int maxSum(int[] nums) {
        int[] freq = new int[101];
        int max =Integer.MIN_VALUE;
        for(int i:nums) {
            if(i<=0){
                max = Math.max(max,i);
                continue;
            }
            freq[i]++;
        }
        int sum =0;
        for(int i=0;i<101;i++){
            if(freq[i]>0) sum+=i;
        }
        if(sum==0) return max;
        return sum;
    }
}
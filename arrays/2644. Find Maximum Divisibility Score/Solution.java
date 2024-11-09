class Solution {
    public int maxDivScore(int[] nums, int[] divisors) {
        int res = Integer.MIN_VALUE;
        int div=Integer.MAX_VALUE;
        for(int i:divisors){
            int count =0;
            for(int j:nums){
                if(j%i==0) count++;
            }
            if(count>res){
                res=count;
                div=i;
            }else if(count>=res){
                div = Math.min(div,i);
            }
        }
        return div;
    }
}

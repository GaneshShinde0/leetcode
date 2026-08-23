class Solution {
    public long maxStrength(int[] nums) {
        if(nums.length==1) return nums[0];
        long res = 1, maxNeg = Integer.MIN_VALUE, negCount=0, posCount=0,zeroCount=0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0) res*=nums[i];
            if(nums[i]<0){
                maxNeg = Math.max(maxNeg,nums[i]);
                negCount++;
            }else if(nums[i]>0){
                posCount++;
            }else{
                zeroCount++;
            }
        }
        if(posCount==0 && (negCount==1||zeroCount== nums.length)) return 0; 
        return res<0?res/maxNeg:res;
    }
}
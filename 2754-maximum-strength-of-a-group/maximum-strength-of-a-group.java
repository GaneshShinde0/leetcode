class Solution {
    public long maxStrength(int[] nums) {
        if (nums.length == 1) return nums[0];
        
        long res = 1;
        int maxNeg = Integer.MIN_VALUE, posCount = 0, negCount = 0;
        
        for (int num : nums) {
            if (num > 0) {
                res *= num;
                posCount++;
            } else if (num < 0) {
                res *= num;
                maxNeg = Math.max(maxNeg, num);
                negCount++;
            }
        }
        
        // If there are no positive numbers, and 1 or 0 negative numbers, 
        // the remaining elements must be zeros. The max product is 0.
        if (posCount == 0 && negCount <= 1) return 0;
        
        // If the product of all non-zero numbers is negative, remove the largest negative
        return res < 0 ? res / maxNeg : res;
    }
}

class SolutionInitial {
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
/*
Input: nums = [-2,-3,1,4]
i=0 => evenCorrect = 1;
i=1 => evenCorrect = 2;
i=2 => oddCorrect = 1;
i=3 => oddCorrect = 2;

*/

class Solution {
    public int[] makeParityAlternating(int[] nums) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int n = nums.length, oddCorrect = 0, evenCorrect = 0;
        if(n==1) return new int[]{0,0};
        for(int i=0;i<n;i++){
            if(i%2==Math.abs(nums[i]%2)){
                evenCorrect++;
            }else{
                oddCorrect++;
            }
            max = Math.max(nums[i], max);
            min = Math.min(nums[i], min);
        }
        int best = Integer.MAX_VALUE;

        if(oddCorrect<=evenCorrect){
            boolean keepMin = false;
            boolean keepMax = false;

            for(int i=0;i<n;i++){
                if(i%2==Math.abs(nums[i]%2)){
                    if(nums[i]==min) keepMin = true;
                    else if(nums[i]==max) keepMax = true;
                }
            }
            int newMin = min;
            int newMax = max;
            if(!keepMin) newMin+=1;
            if(!keepMax) newMax-=1;
            best = Math.min(best, Math.max(newMax-newMin,1));
        }
        if(evenCorrect<=oddCorrect){
            boolean keepMin = false;
            boolean keepMax = false;

            for(int i=0;i<n;i++){
                if(i%2!=Math.abs(nums[i]%2)){
                    if(nums[i]==min) keepMin = true;
                    else if(nums[i]==max) keepMax = true;
                }
            }
            int newMin = min;
            int newMax = max;
            if(!keepMin) newMin+=1;
            if(!keepMax) newMax-=1;
            best = Math.min(best, Math.max(newMax-newMin,1));
        }
        int ans1 = best;
        int ans0 = Math.min(oddCorrect,evenCorrect);
        return new int[]{ans0,ans1};
    }
}
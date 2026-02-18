/*
We need to get minimum sum of making all the elements equal.

*/

class Solution {
    public long minCost(int[] nums, int[] cost) {
        int n = nums.length, target = 0;
        long totalCost = 0,prefixCost = 0, result = 0;
        for(int i:cost) totalCost+=i;
        int[][] numsAndCost = new int[n][2];
        for(int i=0;i<n;i++){
            numsAndCost[i][0] = nums[i];
            numsAndCost[i][1] = cost[i];
        }
        Arrays.sort(numsAndCost,(a,b)->Integer.compare(a[0],b[0]));
        for(int i=0;i<n;i++){
            prefixCost += numsAndCost[i][1];
            if(prefixCost>=(totalCost+1)/2){
                target = i;
                break;
            }
        }
        
        for(int i=0;i<n;i++){
            result += 1l*Math.abs(numsAndCost[i][0]-numsAndCost[target][0])*numsAndCost[i][1];
        }
        return result;
    }
}
/*
Input: gas = [2,3,4], cost = [3,4,3]
-2,-2,-2,3,3

Input: gas = [2,3,4], cost = [3,4,3]
-1,-1,1


*/

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0, n = gas.length;
        int currGain = 0;
        int start = 0;
        for(int i=0;i<n;i++){
            sum+=gas[i]-cost[i];
            currGain+=gas[i]-cost[i];

            if(currGain<0){
                start = i+1;
                currGain = 0;
            }
        }
        return sum<0?-1:start;
    }
}
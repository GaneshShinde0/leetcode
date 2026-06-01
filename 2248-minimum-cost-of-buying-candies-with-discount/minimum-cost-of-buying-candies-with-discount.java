class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int n = cost.length;
        int res = 0,i=n-1;
        for(;i>=1;i-=3){
            res+=cost[i]+cost[i-1];
        }
        if(i==0) res+=cost[0];
        return res;
    }
}
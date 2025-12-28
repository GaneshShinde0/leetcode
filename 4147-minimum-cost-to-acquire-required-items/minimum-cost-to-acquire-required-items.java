class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long res  = 0;
        if((cost1+cost2)>costBoth){
            res +=1l*(costBoth)*Math.min(need1,need2);
            if(need1>need2){
                if(cost1>costBoth){
                    res+=1l*costBoth*(need1-need2);
                }else res += 1l*cost1*(need1-need2);
            }else{
                if(cost2>costBoth){
                    res+=1l*costBoth*(need2-need1);
                }else res += 1l*cost2*(need2-need1);
            }
        }else{
            res+=1l*cost1*need1;
            res+=1l*cost2*need2;
        }
        return res;

    }
}
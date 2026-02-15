class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int res = 0;
        if(startPos[0]<homePos[0]){
            for(int i=startPos[0];i<homePos[0];i++){
                res+=rowCosts[i+1];
            }
        }else{
            for(int i=homePos[0];i<startPos[0];i++){
                res+=rowCosts[i];
            }
        }
        if(startPos[1]<homePos[1]){
            for(int i=startPos[1];i<homePos[1];i++){
                res+=colCosts[i+1];
            }
        }else{
            for(int i=homePos[1];i<startPos[1];i++){
                res+=colCosts[i];
            }
        }
        return res;
    }
}
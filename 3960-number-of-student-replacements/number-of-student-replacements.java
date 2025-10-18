class Solution {
    public int totalReplacements(int[] ranks) {
        int res =0;
        int min = ranks[0];
        for(int i=1;i<ranks.length;i++){
            if(ranks[i]<min){
                min = ranks[i];
                res++;
            } 
        }
        return res;
    }
}
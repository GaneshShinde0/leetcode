class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length();
        int l = 0, r =0;
        int trueCnt = 0, falseCnt = 0;
        int res=0;
        for(;r<n;r++){
            if(answerKey.charAt(r)=='T'){
                trueCnt++;
            }else{
                falseCnt++;
            }
            // Check If number of trues and false are greater than K.
            // If less than K then simply res will be r-l+1;
            // But as number of trues and falses are greater than K then we are checking for a shorter window. 
            // At Every Single Index
            while(trueCnt>k&&falseCnt>k){
                if(answerKey.charAt(l)=='T'){
                    trueCnt -= 1;
                }else{
                    falseCnt -=1;
                }
                l+=1;
            }

            // We are Never reducing R; We are just cheking how many lefts can be incremented.
            res = Math.max(res, r-l+1);
        }
        return res;
    }
}
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
            while(trueCnt>k&&falseCnt>k){
                if(answerKey.charAt(l)=='T'){
                    trueCnt -= 1;
                }else{
                    falseCnt -=1;
                }
                l+=1;
            }
            res = Math.max(res, r-l+1);
        }
        return res;
    }
}
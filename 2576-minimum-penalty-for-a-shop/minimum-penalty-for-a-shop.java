/*
customers = "YYNY"
prefixSum = [0,1,2,2,3]
curr=0, right = 3, res = 0

i= 1
res = Max(0,1-1,4-1-(3-1))= Max(0,0,3-2) = 1

i=2 
res = Max(1, 2-2, 2-(3-2))= (1,0,2-1)=> 1;

i = 3 
res = MAX (1, 3-2,4-3-(3-2))= (1,1,0) => 1;

i = 4
res = Max(4-3, 4-3-(3-3))=1;
*/
class Solution {
    public int bestClosingTimeInitial(String customers) {
        int n = customers.length();
        int[] prefixSum = new int[n+1];
        for(int i=1;i<=n;i++){
            prefixSum[i]=prefixSum[i-1]+(customers.charAt(i-1)=='Y'?1:0);
        }
        int curr = 0, right = prefixSum[n],res = n+1,idx=0;
        for(int i=0;i<=n;i++){
            curr = i-prefixSum[i]+(right-prefixSum[i]);
            if(res>curr){
                res = curr;
                idx = i;
            }
            // N-i => will give window... 
            // right-prefixSum[i] => will give number of y's
            // Number of N's = window - total y's
        }
        return idx;
    }
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int[] prefixSum = new int[n+1];
        for(int i=1;i<=n;i++){
            prefixSum[i]=prefixSum[i-1]+(customers.charAt(i-1)=='Y'?1:0);
        }
        int minPenalty = n + 1;
        int bestHour = 0;

        for (int i = 0; i <= n; i++) {
            int nsBefore = i - prefixSum[i];
            int ysAfter = prefixSum[n] - prefixSum[i];
            int penalty = nsBefore + ysAfter;
            
            if (penalty < minPenalty) {
                minPenalty = penalty;
                bestHour = i;
            }
        }
        return bestHour;
    }
}
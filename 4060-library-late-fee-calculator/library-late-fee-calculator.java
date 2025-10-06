class Solution {
    public int lateFee(int[] daysLate) {
        int n = daysLate.length, res = 0;
        for(int i=0;i<n;i++){
            int curr = daysLate[i];
            if(daysLate[i]==1)res++;
            else if(2<=curr && curr<=5) res+=2*curr;
            else res+=3*(curr);
        }
        return res;
    }
}
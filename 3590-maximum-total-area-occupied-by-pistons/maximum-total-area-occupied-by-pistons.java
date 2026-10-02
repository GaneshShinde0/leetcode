class Solution {
    public long maxArea(int h, int[] ps, String ds){
        int n = ps.length;
        long[] timeline = new long[h*2+2];
        long[] presum = new long[h*2+2];
        long sum = 0, res = 0;
        for(int i=0;i<n;i++){
            sum += ps[i];
            if(ds.charAt(i)=='U' || ps[i] == 0){
                timeline[1] += 1;
                timeline[h-ps[i]+1] += -2;
                timeline[2*h-ps[i]+1] += 2;
            }else{
                timeline[1] += -1;
                timeline[ps[i]+1] += 2;
                timeline[ps[i]+1+h] += -2;
            }
        }
        for(int i= 1;i< timeline.length; i++){
            timeline[i] += timeline[i-1];
            presum[i] += presum[i-1]+timeline[i];
            res = Math.max(res, sum+presum[i]);
        }
        return res;
    }
}
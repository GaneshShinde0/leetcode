class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long max = 0;
        for(int time:workerTimes) max= Math.max(time,max);
        long maxTime = (max*mountainHeight*(mountainHeight+1))/2;
        long left = 0, right = maxTime, ans = 0;
        while(left<right){
            long mid = (left+right)/2;
            if(canComplete(workerTimes,mid, mountainHeight)){
                ans = mid;
                right = mid;
            }else{
                left = mid+1; 
            }
        }
        return right;
    }
    private boolean canComplete(int[] times, long mid, int mountainHeight){
        long timeTaken=0;
        for(int t:times){
            long work = mid/t;
            timeTaken += (long)((-1.0+Math.sqrt(1+work*8))/2);
        }
        return timeTaken>=mountainHeight;
    }
}


/*

So basically we have to find minimum of (workerTimes[i])(k*(k+1)/2) <= mid --- as we are checking with mid.

rearrange the equation 
k(k+1)/2 <= (mid/workerTimes[i]);
consider work being done as (work = mid/workerTimes[i]);

equation becomes 
k(k+1)/2 <= work;

k(k+1)/2-work<=0;
k^2+k-2*work<=0;
equation for k becomes

(-b+- (b^2-4*a*c)^1/2)/2

In this case

(-1+-(1-4*1*2*work)^1/2)/2

Finally it comes -- we ignore -ve as it will give us negative ans.
((-1+(1-8*work))^1/2)/2



*/
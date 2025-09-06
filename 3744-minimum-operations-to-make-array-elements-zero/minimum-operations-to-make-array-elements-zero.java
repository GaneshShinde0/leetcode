class Solution {
    public long minOperations1(int[][] queries) {
        long res = 0;
        for(int[] q : queries){
            long count1 = get(q[1]);
            long count2 = get(q[0]-1);
            res+=(count1-count2+1)/2;
        }
        return res;
    }

    private long get(int num){
        long count = 0;
        int i = 1;
        int base = 1;
        while(base<=num){
            int end = Math.min(base*2-1,num);
            count += (long) ((i+1)/2)*(end-base+1);
            i++;
            base *= 2;
        }
        return count;
    }

    long getCount(long n){
        long cnt = 1 + ((n == 0)?0: (long)(Math.log(n) / Math.log(4)));   // this is just 1 + log n to base 4 i.e log(a)/log(b) = log(n)/log(4)
        long sumOfGp = ((cnt <= 0)?0: (long)((Math.pow(4, cnt) - 1)/3));  // sum of gp = a.(r^t -1)/(r - 1) and here a = 1, r = 4 and t = cnt
        return cnt * (n + 1) - sumOfGp;                                   // apply the formula we deduced
    } 

    long minOperations(int[][] queries) {
        long ans = 0;
        for(int[] q: queries) ans += (getCount(q[1]) - getCount(q[0]-1) + 1)/2;
        return ans;
    }
}
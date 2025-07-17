class Solution {
    public int binaryGapInitialSolution(int n) {
        String s = Integer.toBinaryString(n);
        int res = 0, prev =s.indexOf('1'), len = s.length();
        for(int i=prev; i<len; ++i){
            if(s.charAt(i)=='1'){
                res = Math.max(res,i-prev);
                prev = i;
            }
        }
        return res;
    }
    public int binaryGap(int n) {
        int ans = 0;
        for (int d = -32; n > 0; n /= 2, ++d)
        if (n % 2 == 1) {
            ans = Math.max(ans, d);
            d = 0;
        }

        return ans;
    }
}
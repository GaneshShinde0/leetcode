class Solution {
    public int binaryGap(int n) {
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
}
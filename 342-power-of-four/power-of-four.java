class Solution {
    public boolean isPowerOfFourWithLoop(int n) {
        if(n==1) return true;
        if(n<=0) return false;
        long t= Math.abs(n);
        while(t>1){
            if(t%4!=0)return false;
            t/=4;
        }
        return true;
    }


    public boolean isPowerOfFour(int n) {
        if(n<1) return false;
        String s = Integer.toBinaryString(n);
        return s.charAt(0)=='1'&&Integer.bitCount(n)==1&&s.length()%2==1;
    }

}
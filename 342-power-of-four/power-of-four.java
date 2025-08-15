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

    // This is without for loop and recursion
    // toBinarystring,bitCount uses loop in the backend
    public boolean isPowerOfFour1(int n) {
        if(n<1) return false;
        String s = Integer.toBinaryString(n);
        return s.charAt(0)=='1'&&Integer.bitCount(n)==1&&s.length()%2==1;
    }

    public boolean isPowerOfFour(int n) {
        // Check if n is positive and only one bit is set (power of 2)
        // Also check that the only set bit is at an even position (0-based)
        return n > 0 && (n & (n - 1)) == 0 && (n & 0xAAAAAAAA) == 0;
    }


}
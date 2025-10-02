class Solution {
    public int reverseBitsInitial(int n) {
        String s = Integer.toBinaryString(n);
        // System.out.println("Original: "+s);

        StringBuilder rev = new StringBuilder(s).reverse();
        while(rev.length()<32){
            rev.append(0);
        }
        // System.out.println(rev.toString());
        return Integer.parseInt(rev.toString(),2);

    }
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans <<= 1;
            ans |= (n & 1);
            n >>= 1;
        }
        return ans;
    }
}
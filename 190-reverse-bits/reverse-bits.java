class Solution {
    public int reverseBits(int n) {
        String s = Integer.toBinaryString(n);
        // System.out.println("Original: "+s);

        StringBuilder rev = new StringBuilder(s).reverse();
        while(rev.length()<32){
            rev.append(0);
        }
        // System.out.println(rev.toString());
        return Integer.parseInt(rev.toString(),2);

    }
}
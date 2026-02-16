class Solution {
    public int reverseBits(int n) {
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(n));
            sb = sb.reverse();
            while(sb.length()<32){sb.append("0");}
            return Integer.parseInt(sb.toString(),2);
        }
    }

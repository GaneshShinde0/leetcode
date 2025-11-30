class Solution {
    public String encode(int num) {
        // if(num==0) return "";
        // if(num==1) return "0";
        // int msb = Integer.highestOneBit(num);
        // int mask = ~msb;
        // int res = num&mask;
        // System.out.println(msb+" , "+(int)(Math.log(msb)/Math.log(2)));
        // int msbPos = (int)(Math.log(msb)/Math.log(2));
        // String s= Integer.toBinaryString(res+1);
        // return "0".repeat(msbPos-s.length())+s;
        // // 101011
        return Integer.toBinaryString(num+1).substring(1);
    }
}
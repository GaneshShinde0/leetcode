class Solution {
    public long maxNumber(long n) {
        String s = Long.toBinaryString(n);
        String ones = "1".repeat(s.length());
        char[] ch = ones.toCharArray();
        long res = Long.parseLong(ones,2);

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                ch[i]='0';
            }
            res = Math.min(res,Long.parseLong(new String(ch),2));
            ch[i]='1';
        }
        return res;
    }
}
/*
111 -> 7

110
101
011

10001

01111
10000*/
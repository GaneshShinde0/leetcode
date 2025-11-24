class Solution {
    public int minimumFlips(int n) {
        String s = Integer.toBinaryString(n);
        int res = 0;
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-1-i)) res++;
        }
        return res*2;
    }
}
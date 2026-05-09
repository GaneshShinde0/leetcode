class Solution {
    public int minFlips(String s) {
        int count1 = 0,count0=0;
        for(char c:s.toCharArray()){
            if(c=='1')count1++;
            else count0++;
        }
        if(count1>=2 && s.charAt(0)=='1' && s.charAt(s.length()-1)=='1') return Math.min(Math.max(0,count1-2),count0);
        return Math.min(Math.max(0,count1-1),count0);
    }
}
class Solution {
    private final int MOD = 1_000_000_007;
    public int numWays(String s) {
        int ones = 0;
        int n = s.length(), subOnes = 0, zerosInFirstGap = 0, zerosInSecondGap=0;
        for(char c:s.toCharArray()) if(c=='1') ones++;
        if(ones==0) return (int) ((1l*(n-1)*(n-2)/2)%MOD);
        if(ones%3!=0) return 0;
        boolean oneFound = false;        
        for(char c:s.toCharArray()){
            if(c=='1') subOnes++;
            if(subOnes == ones/3) zerosInFirstGap++;
            else if(subOnes == (ones*2)/3) zerosInSecondGap++;
        }
        return (int) ((1l*zerosInFirstGap*zerosInSecondGap)%MOD);
    }
}
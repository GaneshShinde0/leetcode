class Solution {
    public int countDigitOne(int n) {
        int result = 0;
        for(int i=1;i<=n;i*=10){
            int divider = i*10;
            result += (n/divider)*i+Math.min(i,Math.max(n%divider-i+1,0));
        }
        return result;
    }
}
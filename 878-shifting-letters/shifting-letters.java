class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int n = shifts.length;
        long suffixSum = shifts[n-1];
        StringBuilder sb = new StringBuilder();
        for(int i=n-1;i>=0;i--){
            char c = (char)('a'+ (s.charAt(i)-'a' + (suffixSum%26))%26);
            sb.insert(0,c);
            if(i>0) suffixSum+=shifts[i-1];
        }
        return sb.toString();
    }
}
class Solution {
    public String shiftingLettersInitial(String s, int[] shifts) {
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
    // Following reduces time from 718 to 13 ms
    public String shiftingLettersSB(String s, int[] shifts) {
        int n = shifts.length;
        long suffixSum = shifts[n-1];
        StringBuilder sb = new StringBuilder();
        for(int i=n-1;i>=0;i--){
            char c = (char)('a'+ (s.charAt(i)-'a' + (suffixSum))%26);
            sb.append(c);
            if(i>0) suffixSum=(suffixSum+shifts[i-1])%26;
        }
        return sb.reverse().toString();
    }
    public String shiftingLetters(String s, int[] shifts) {
        int n = shifts.length;
        int suffixSum = shifts[n-1];
        var sa = s.toCharArray();
        for(int i=n-1;i>=0;i--){
            sa[i]= (char)('a'+ (s.charAt(i)-'a' + (suffixSum))%26);
            if(i>0) suffixSum=(suffixSum+shifts[i-1])%26;
        }
        return new String(sa);
    }
}
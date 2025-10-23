class Solution {
    public boolean hasSameDigits(String s) {
        while (s.length() > 2) {
            StringBuilder newS = new StringBuilder();
            
            for (int i = 0; i < s.length() - 1; i++) {
                int sumMod10 = (s.charAt(i) - '0' + s.charAt(i + 1) - '0') % 10;
                newS.append(sumMod10);
            }
            
            s = newS.toString();
        }
        return s.charAt(0) == s.charAt(1);
    }
}
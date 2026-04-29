class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String duplicate = s.substring(1)+s.substring(0,s.length()-1);
        return duplicate.contains(s); 
    }
}
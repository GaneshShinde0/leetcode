class Solution {
    public boolean canBeEqual(String s1, String s2) {
        return new String(new char[]{s1.charAt(0),s1.charAt(3),s1.charAt(2),s1.charAt(1)}).equals(s2)||new String(new char[]{s1.charAt(2),s1.charAt(1),s1.charAt(0),s1.charAt(3)}).equals(s2)||new String(new char[]{s1.charAt(2),s1.charAt(3),s1.charAt(0),s1.charAt(1)}).equals(s2)||s1.equals(s2);
    }
}
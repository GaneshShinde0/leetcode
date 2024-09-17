class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int count=0;
        int[] flags = new int[26];
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                count++;
                if(count>2) return false;
                flags[s1.charAt(i)-'a']++;
                flags[s2.charAt(i)-'a']--;
            }
        }
        for(int b:flags){
            if(b!=0) return false;
        }
        return true;
    }
}

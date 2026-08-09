class Solution {
    
    public boolean checkIfCanBreak(String s1, String s2) {
        int[] freq1 = new int[26], freq2 = new int[26];
        for(char c:s1.toCharArray()) freq1[c-'a']++;
        for(char c:s2.toCharArray()) freq2[c-'a']++;
        StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder();
        for(int i=0;i<26;i++){
            sb1.append(((char)('a'+i)+"").repeat(freq1[i]));
            sb2.append(((char)('a'+i)+"").repeat(freq2[i]));
        }
        s1 = sb1.toString();
        s2 = sb2.toString();
        int inc = 0, dsc = 0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)>s2.charAt(i)) inc += 1;
            else if(s2.charAt(i)>s1.charAt(i)) dsc += 1;
            else{
                inc++;
                dsc++;
            }
        }
        return inc == s1.length() || dsc == s1.length();
    }
    
    public boolean checkIfCanBreakDoesNotWork(String s1, String s2) {
        int[] freq1 = new int[26], freq2 = new int[26];
        for(char c:s1.toCharArray()) freq1[c-'a']++;
        for(char c:s2.toCharArray()) freq2[c-'a']++;
        int temp = 0;
        for(int i=0;i<26;i++){
            if(freq1[i]>=freq2[i]) temp+=freq1[i];
        }
        if(temp == s1.length()) return true;
        temp = 0;
        for(int i=0;i<26;i++){
            if(freq1[i]<=freq2[i]) temp+=freq2[i];
        }
        if(temp == s1.length()) return true;
        return false;
    }
}
class Solution {
    public char findTheDifference(String s, String t) {
        int[] letters = new int[26];
        // char[] schars = s.toCharArray();
        // char[] tchars = t.toCharArray();
        // for(char sc:schars){
        //     letters[sc-97]+=1;
        // }
        // for(char tc:tchars){
        //     letters[tc-97]-=1;
        // }
        for(int i=0;i<s.length();i++){
            letters[s.charAt(i)-97]+=1;
            letters[t.charAt(i)-97]-=1;
        }
        for(int i=0;i<26;i++){
            if(letters[i]==-1){
                return (char) (i+97);
            }
        }
        return t.charAt(t.length()-1);
    }
}

class Solution {
    public boolean closeStrings(String s, String t) {
       int[] src = anagrams(s);
        int[] tgt = anagrams(t);
        int temp = 0;
        for(int i=0;i<26;i++){
            if((src[i]==0 && tgt[i]!=0 )||(src[i]!=0 && tgt[i]==0 )) return false;
        }
        Arrays.sort(src);
        Arrays.sort(tgt);
        for(int i=0;i<26;i++){
            if(src[i]!=tgt[i]) return false;
        }
        return true;
    }
    private int[] anagrams(String s){
        int[] temp = new int[26];
        for(char c:s.toCharArray()){
            temp[c-'a']++;
        }
        return temp;
    }
}
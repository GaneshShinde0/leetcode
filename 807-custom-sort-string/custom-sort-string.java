class Solution {
    public String customSortString(String order, String s) {
        int[] freq = new int[26];
        StringBuilder sb = new StringBuilder();
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }
        for(char c:order.toCharArray()){
            if(order.indexOf(c)!=-1){
                for(int i=0;i<freq[c-'a'];i++) sb.append(c);
            }
        }
        for(int i=0;i<26;i++){
            if(order.indexOf((char)(i+'a'))==-1){
                for(int j=0;j<freq[i];j++) sb.append((char)(i+'a'));
            }
        }
        return sb.toString();
    }
}
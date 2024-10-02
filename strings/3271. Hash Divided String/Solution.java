class Solution {
    public String stringHash(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i+=k){
            int temp=0;
            for(int j=i;j<Math.min(i+k,s.length());j++){
                temp+=s.charAt(j)-'a';
            }
            sb.append((char)(temp%26+97));
        }
        return sb.toString();
    }
}

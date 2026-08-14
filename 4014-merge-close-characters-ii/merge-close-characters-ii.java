class Solution {
    public String mergeCharacters(String s, int k) {
        int[] lastIdx = new int[26];
        Arrays.fill(lastIdx,-1);
        StringBuilder sb  = new StringBuilder();
        for(int i=0,j=0;i<s.length();i++){
            int idx = s.charAt(i)-'a';
            if(lastIdx[idx]!=-1 && (j-lastIdx[idx])<=k){
                continue;
            }else{
                sb.append(s.charAt(i));
                lastIdx[idx]=j;
                j++;
            }
        }
        return sb.toString();
    }
}
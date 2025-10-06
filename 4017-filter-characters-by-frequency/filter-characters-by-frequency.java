class Solution {
    public String filterCharacters(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int[] freq = new int[128];
        for(char c:s.toCharArray()){
            freq[c]++;
        }
        for(char c:s.toCharArray()){
            if(freq[c]>0 && freq[c]<k)sb.append(c);
        }
        return sb.toString();
        
    }
}
class Solution {
    public String largestPalindromic(String num) {
        int[] freq = new int[10];
        for(char c:num.toCharArray()){
            freq[c-'0']++;
        }
        StringBuilder sb = new StringBuilder();
        int curr = 0;
        for(int i=9;i>=0;i--){
            if(curr==0 && i==0) break;
            while(freq[i]>=2){
                char c = (char) (i+'0');
                sb.insert(sb.length()-curr,c);
                sb.insert(curr,c);
                freq[i]-=2;
                curr++;
            }
        }
        for(int i=9;i>=0;i--){
            if(freq[i]%2==1){
                sb.insert(curr,i);
                break;
            }
        }
        if(sb.isEmpty()) return "0";
        return sb.toString();
    }
}
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
                StringBuilder builder = new StringBuilder(freq[i]/2); // Optional: pre-size for efficiency
                for (int j = 0; j < freq[i]/2; j++) {
                    builder.append(c);
                }
                sb.insert(sb.length()-curr,builder.toString());
                sb.insert(curr,builder.toString());
                // System.out.println(sb.toString());
                // System.out.println(curr);
                curr+=freq[i]/2;
                freq[i]=freq[i]%2;
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
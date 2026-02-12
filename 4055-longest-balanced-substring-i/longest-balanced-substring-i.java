class Solution {
    // Will optimize later
    public int longestBalanced(String s) {
        int res = 0;
        int n = s.length();
        for(int i=0;i<n;i++){
            int[] freq = new int[26];
            for(int j=i;j<n;j++){
                freq[s.charAt(j)-'a']++;
                if(checkFreq(freq)){
                    res = Math.max(res,j-i+1);                    
                }
            }
        }
        return res;
    }

    private boolean checkFreq(int[] freq){
        int temp =0;
        for(int i=0;i<26;i++){
            if(temp!=0 && freq[i]!=0 && freq[i]!=temp) return false;
            if(freq[i]!=0){
                temp=freq[i];
            }
        }
        return true;
    }
}
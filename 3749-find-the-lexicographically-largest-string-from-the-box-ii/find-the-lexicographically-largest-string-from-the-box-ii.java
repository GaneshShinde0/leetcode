class Solution {
    public String answerString(String word, int numFriends) {
        return sln1(word, numFriends);
    }

    private String sln1(String s, int l){
        if(l==1) return s;
        int k = 0;
        int i = 0; int j = 1;
        int n = s.length();
        while (j+k<n){
            int diff = s.charAt(i+k)-s.charAt(j+k);
            if(diff == 0){
                k++;
            }else if(diff>0){
                j = j+k+1;
                k = 0;
            }else{
                i = Math.max(i+k+1, j);
                j = i+1;
                k = 0;
            }
        }

        return s.substring(i, Math.min(n, i+n-l+1));
    }
}
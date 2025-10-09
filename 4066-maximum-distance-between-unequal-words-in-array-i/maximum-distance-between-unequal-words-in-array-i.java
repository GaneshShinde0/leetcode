class Solution {
    public int maxDistance(String[] words) {
        int n = words.length;
        // int res = 0;
        for(int i=0;i<n;i++){
            if(!words[i].equals(words[n-i-1])) return n-i;
            else if (i+1<n && !words[i+1].equals(words[n-i-1])) return n-i-1;
        }
        return 0;
    }
}
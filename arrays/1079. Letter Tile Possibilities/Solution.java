class Solution {
    public int numTilePossibilities(String tiles) {
        int[] freq = new int[26];
        for(char c: tiles.toCharArray()){
            freq[c-'A']++;
        }
        int res=0;

        return generateSequences(freq);
    }

    private int generateSequences(int[] freq){
        int count=0;
        for(int i=0;i<26;i++){
            if(freq[i]==0) continue;
            count++;
            freq[i]--;
            count+=generateSequences(freq);
            freq[i]++;
        }
        return count;
    }
}

class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int count=0;
        for(int i=0;i<words.length;i++){
            for(int j=0; j<words.length&&i!=j;j++){
                if(words[i].startsWith(words[j])&& words[i].endsWith(words[j]))count++;
            }
        }
        return count;
    }
}

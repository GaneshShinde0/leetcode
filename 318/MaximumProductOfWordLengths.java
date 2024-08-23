class MaximumProductOfWordLengths {
    public int maxProductNaive32Ms(String[] words) {
        int[][] freq = new int[words.length][26];
        for(int i=0;i<words.length;i++){
            freq[i]=countFrequencies(words[i]);
        }
        int maxSum = 0;
        for(int i=0;i<words.length-1;i++){
            for(int j=i+1;j<words.length;j++){
                int k=0;
                for(k=0;k<26;k++){
                    if(freq[i][k]>0 && freq[j][k]>0) break;
                }
                if (k==26){
                    maxSum = Math.max(maxSum,words[i].length()*words[j].length());
                }
            }
        }
        return maxSum;
    }

    private int[] countFrequencies(String word){
        int[] arr = new int[26];
        for(char c: word.toCharArray()){
            arr[c-'a']++;
        }
        return arr;
    }
    // Bit mask takes 12 ms
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] masks = new int[n]; // Stores the bitmask for each word
        int[] lengths = new int[n]; // Stores the lengths of each word
        
        // Precompute the bitmask and length for each word
        for (int i = 0; i < n; i++) {
            int mask = 0;
            for (char c : words[i].toCharArray()) {
                mask |= 1 << (c - 'a'); // Set the bit corresponding to the character
            }
            masks[i] = mask;
            lengths[i] = words[i].length();
        }
        
        // Find the maximum product of lengths of words with no common characters
        int maxProduct = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((masks[i] & masks[j]) == 0) { // No common characters
                    maxProduct = Math.max(maxProduct, lengths[i] * lengths[j]);
                }
            }
        }
        
        return maxProduct;
    }
}

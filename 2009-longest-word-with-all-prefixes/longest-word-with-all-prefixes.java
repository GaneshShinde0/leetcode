class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        // Set to store valid words
        Set<String> validWords = new HashSet<>();
        String longestValidWord = "";

        // Iterate throgh each word
        for(String currentWord: words){
            // Check if the word is of length 1 or if its prefix exists in the set
            if(currentWord.length()==1 || validWords.contains(currentWord.substring(0,currentWord.length()-1))){
                validWords.add(currentWord);
                if(longestValidWord.length()<currentWord.length()){
                    longestValidWord = currentWord;
                }
            }
        }

        // Return the longest valid word found.
        return longestValidWord;
    }
}
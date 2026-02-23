class Solution {
    public String longestWordUsingSet(String[] words) {
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

    public String longestWord(String[] words) {
        String result="";
        Trie trie = new Trie();
        for(String word:words){
            trie.insert(word);
        }
        for(String word:words){
            if(trie.hasAllPrefixes(word)){
                if(word.length()>result.length()||(word.length()==result.length() && word.compareTo(result)<0)) result = word;
            }
        }
        return result;
    }
    private static class Trie{
        public static class TrieNode{
            TrieNode[] children = new TrieNode[26];
            boolean isEndOfWord;
        }
        private final TrieNode root = new TrieNode();
        // Insert a word into the trie.
        private void insert(String word){
            TrieNode node = root;
            for(char c:word.toCharArray()){
                int index = c-'a';
                if(node.children[index]==null){
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.isEndOfWord = true;
        }

        private boolean hasAllPrefixes(String word){
            TrieNode node = root;
            for(char c:word.toCharArray()){
                node = node.children[c-'a'];
                if(node==null || !node.isEndOfWord){
                    return false;
                }
            }
            return true;
        }
    }
}

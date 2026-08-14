class MagicDictionaryUsingHashMap {
    HashMap<String,Integer> mapOfComb;
    Set<String> words;

    public MagicDictionaryUsingHashMap() {
        this.mapOfComb = new HashMap<>();
        this.words = new HashSet<>();
    }
    
    public void buildDict(String[] dictionary) {
        for(String word:dictionary){
            int len = word.length();
            words.add(word);
            for(int i=0;i<len;i++){
                String comb = (word.substring(0,i)+"*"+word.substring(i+1));
                mapOfComb.put(comb, mapOfComb.getOrDefault(comb,0)+1);
            }
        }
    }
    
    public boolean search(String word) {
        int len = word.length();
        for(int i=0;i<len;i++){
            String comb = word.substring(0,i)+"*"+word.substring(i+1);
            if(words.contains(word)){
                if(mapOfComb.get(comb)>=2) return true;
            }
            else if(mapOfComb.containsKey(comb)) return true;
        }
        return false;
    }
}

class MagicDictionary {
    
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord = false;
    }
    
    TrieNode root;

    public MagicDictionary() {
        root = new TrieNode();
    }
    
    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new TrieNode();
                }
                curr = curr.children[c - 'a'];
            }
            curr.isEndOfWord = true;
        }
    }
    
    public boolean search(String searchWord) {
        // Start the DFS from the root, at index 0, with 0 modifications made so far
        return dfs(root, searchWord, 0, false);
    }
    
    private boolean dfs(TrieNode node, String word, int index, boolean modified) {
        // Base case: If we've reached the end of the word
        if (index == word.length()) {
            // It must be a valid word in the dictionary AND exactly 1 character was modified
            return node.isEndOfWord && modified;
        }
        char currentChar = word.charAt(index);
        // Check all possible next characters in the Trie
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                // If the character matches, continue DFS without changing 'modified' status
                if (i == currentChar - 'a') {
                    if (dfs(node.children[i], word, index + 1, modified)) {
                        return true;
                    }
                } 
                // If the character does NOT match, we can only proceed if we haven't modified yet
                else if (!modified) {
                    if (dfs(node.children[i], word, index + 1, true)) {
                        return true;
                    }
                }
            }
        }
        // If no valid path was found, return false
        return false; 
    }
}
/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */
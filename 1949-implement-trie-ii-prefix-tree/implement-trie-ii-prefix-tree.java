class Trie {
    class TrieNode{
        int[] freq;
        TrieNode[] children;
        int endsCount;
        public TrieNode() {
            this.freq=new int[26];
            this.children = new TrieNode[26];
            this.endsCount = 0;
        }
    }
    private TrieNode root;
    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        int n = word.length();
        TrieNode curr = this.root;
        for(int i=0;i<n;i++){
            char c= word.charAt(i);
            if(curr.children[c-'a']==null){
                curr.children[c-'a']= new TrieNode();
            }
            curr = curr.children[c-'a'];
            curr.freq[c-'a']++;
        }
        curr.endsCount++;
    }
    
    public int countWordsEqualTo(String word) {
        int n = word.length();
        TrieNode curr = this.root;
        for(int i=0;i<n;i++){
            char c = word.charAt(i);
            if(curr.children[c-'a']==null) return 0;
            curr = curr.children[c-'a'];
        }
        return curr.endsCount;
    }
    
    public int countWordsStartingWith(String prefix) {
        int startsWith = Integer.MAX_VALUE;
        int n = prefix.length();
        TrieNode curr = this.root;
        for(int i=0;i<n;i++){
            char c = prefix.charAt(i);
            if(curr.children[c-'a']==null) return 0;
            curr = curr.children[c-'a'];
            startsWith = Math.min(curr.freq[c-'a'],startsWith);
        }
        return startsWith;
    }
    
    public void erase(String word) {
        int n = word.length();
        TrieNode curr = this.root;
        for(int i=0;i<n;i++){
            char c= word.charAt(i);
            curr = curr.children[c-'a'];
            curr.freq[c-'a']--;
        }
        curr.endsCount--;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */
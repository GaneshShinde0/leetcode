class TrieNode{
    TrieNode[] children = new TrieNode[26];
    int idx = Integer.MAX_VALUE;
    int minLen = Integer.MAX_VALUE;
    TrieNode(){
        for(int i=0;i<26;i++){
            children[i]=null;
        }
    }
}
class Solution {
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        TrieNode trie = new TrieNode();
        for(int id = 0;id<wordsContainer.length;id++){
            String word=new StringBuilder(wordsContainer[id]).reverse().toString();
            int n= word.length();
            TrieNode currNode = trie;
            if(n<currNode.minLen){
                currNode.idx=id;
                currNode.minLen = n;
            }
            for(int i=0;i<n;i++){
                char c = word.charAt(i);
                if(currNode.children[c-'a']==null) currNode.children[c-'a']=new TrieNode();
                currNode = currNode.children[c-'a'];
                if(n<currNode.minLen){
                    currNode.idx=id;
                    currNode.minLen = n;
                }
            }
        }
        int[] res = new int[wordsQuery.length];
        for(int i=0;i<wordsQuery.length;i++){
            String query = new StringBuilder(wordsQuery[i]).reverse().toString();
            int n = query.length();
            TrieNode currNode = trie;
            for(int j=0;j<n;j++){
                char c = query.charAt(j);
                if(currNode.children[c-'a']==null) break;
                currNode = currNode.children[c-'a'];
            }
            res[i]=currNode.idx;
        }
        return res;
    }
}
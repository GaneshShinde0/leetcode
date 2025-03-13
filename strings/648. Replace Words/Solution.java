/* 46ms Beats 40.99%
class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] temp = sentence.split(" ");
        Collections.sort(dictionary);
        for(int i=0;i<temp.length;i++){
            for(int j=0;j<dictionary.size();j++){
                if(temp[i].startsWith(dictionary.get(j))){
                    temp[i]=dictionary.get(j);
                    break;
                }
            }
        }
        return String.join(" ",temp);
    }
}
*/
class TrieNode{
    Map<Character, TrieNode> children;
    boolean isWord;
    String word;
    TrieNode() {
        this.children = new HashMap<>();
    }
}

class Trie{
    TrieNode root;
    public Trie(){
        this.root = new TrieNode();
    }
    
    public void insertWord(String word){
        TrieNode temp  = root;
        for(char c : word.toCharArray()){
            if(temp.children.get(c) == null){
                temp.children.put(c, new TrieNode());
            }
            temp = temp.children.get(c);
        }
        temp.isWord = true;
        temp.word = word;
    }
    
    public String findRoot(String word){
        String ans = null;
        TrieNode temp = root;
        for(char c : word.toCharArray()){
            if(temp.isWord) return temp.word;
            if(temp.children.get(c) == null) break;
            //System.out.println(temp.isWord);
            temp = temp.children.get(c);
        }
        return ans;
    }
}
class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for(String word : dictionary){
            trie.insertWord(word);
        }
        StringBuilder ans = new StringBuilder();
        for(String word : sentence.split(" ")){
            String root = trie.findRoot(word);
            if(root == null || root.isEmpty()) ans.append(word);
            else ans.append(root);
            ans.append(" ");
        }
        String ans1 =  ans.toString();
        return ans1.substring(0, ans1.length() - 1);
    }
}

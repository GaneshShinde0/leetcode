class TrieNode{
    TrieNode[] next = new TrieNode[26];
    int count=0;
}
class Solution {

    TrieNode root = new TrieNode();
    public int[] sumPrefixScoresNaiveVerySlow(String[] words) {
        int[] counts = new int[words.length];
        int idx = 0;
        for(String s:words){
            int count =0;
            for(int i=0;i<s.length();i++){
                count+=check(s.substring(0,i+1),words);
            }
            counts[idx]=count;
            idx++;
        }
        return counts;
    }
    public int check(String s,String[] words){
        int count=0;
        for(String str:words){
            if(str.startsWith(s)) count++;
        }
        return count;
    }

    public int[] sumPrefixScoresUsingHashMap(String[] words) {
        int[] counts = new int[words.length];
        int idx = 0;
        HashMap<String,Integer> map = new HashMap<>();
        for(String s:words){
            int count =0;
            for(int i=0;i<s.length();i++){
                int temp = check(s.substring(0,i+1),words,map);
                count+=temp;
                map.put(s.substring(0,i+1),temp);
            }
            counts[idx]=count;
            idx++;
        }
        return counts;
    }


    public int check(String s,String[] words,Map<String,Integer> map){
        if(map.containsKey(s)) return map.get(s);
        int count=0;
        for(String str:words){
            if(str.startsWith(s)) count++;
        }
        return count;
    }

    


    public int[] sumPrefixScores(String[] words) {
        int[] counts = new int[words.length];
        int idx = 0;
        for(String s:words){
            insert(s);
        }

        for(int i=0;i<counts.length;i++){
            counts[i]=get(words[i]);
        }
        return counts;
    }
    public void insert(String s){
        TrieNode node = root;
        for(int i=0;i<s.length();i++){
            if(node.next[s.charAt(i)-'a']==null){
                node.next[s.charAt(i)-'a'] = new TrieNode();
            }
            node.next[s.charAt(i)-'a'].count++;
            node = node.next[s.charAt(i)-'a'];
        }
    }

    public int get(String s){
        TrieNode node = root;
        int count=0;
        for(char c:s.toCharArray()){
            count+=node.next[c-'a'].count;
            node = node.next[c-'a'];
        }
        return count;
    }

}

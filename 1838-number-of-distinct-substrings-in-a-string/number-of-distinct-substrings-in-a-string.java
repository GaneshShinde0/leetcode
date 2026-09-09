class Solution {
    class Node{
        Node[] children = new Node[26];
    }
    public int countDistinct(String s) {
        Node root = new Node();
        int res = 0;
        for(int i=0;i<s.length();i++){
            Node curr = root;
            for(int j=i;j<s.length();j++){
                if(curr.children[s.charAt(j)-'a']==null){
                    curr.children[s.charAt(j)-'a'] = new Node();
                    res++;
                }
                curr = curr.children[s.charAt(j)-'a'];
            }
        }
        return res;
    }
}
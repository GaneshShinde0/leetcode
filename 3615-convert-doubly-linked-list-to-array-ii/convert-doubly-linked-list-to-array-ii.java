/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
};
*/

class Solution {
    public int[] toArray(Node node) {
        if(node == null) return new int[]{};
        Node temp = node;
        int left = 0;
        while(temp.prev!=null){
            temp = temp.prev;
            left++;
        }
        temp = node;
        int right = 0;
        while(temp.next!=null){
            temp = temp.next;
            right++;
        }
        
        int[] res = new int[left+right+1];
        for(int i=left+right;i>=0;i--){
            res[i] = temp.val;
            temp=temp.prev;
        }
        return res;
    }
}
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
};
*/

class Solution {
    public int[] toArray(Node head) {
        int count = 0;
        while(head.next!=null){
            count++;
            head=head.next;
        }
        int res[]=new int[count+1];
        for(int i=count;i>=0;i--){
            res[i]=head.val;
            head = head.prev;
        }
        return res;
    }
}
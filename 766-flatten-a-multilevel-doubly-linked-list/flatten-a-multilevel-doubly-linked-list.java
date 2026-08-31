/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head == null) return null;
        Node[] headTail = getHeadAndTail(head);
        return headTail[0];
    }

    private Node[] getHeadAndTail(Node head){
        Node temp = new Node(-1), prev = head;
        temp.next = head;
        while(head!=null){
            Node next = head.next;
            if(head.child!=null){
                Node[] headTail = getHeadAndTail(head.child);
                headTail[0].prev = head;
                head.next = headTail[0];
                if(next!=null){
                    next.prev = headTail[1];
                    headTail[1].next = next;
                }
                head.child=null;
                prev = headTail[1];
            }else{
                prev = head;
            }
            head = next;
        }
        return new Node[]{temp.next,prev};
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class N21MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode currNode = new ListNode();
        ListNode head= currNode;
        while(head1!=null&&head2!=null){
            if(head1.val<head2.val){
                //We are creating new Node because incase head1's next value is not null there will be issues and new nodes next value will always be null
                currNode.next=new ListNode(head1.val);
                head1=head1.next;
            }else{
                currNode.next=new ListNode(head2.val);
                head2=head2.next;
            }
            currNode=currNode.next;
        }
        if(head1==null) currNode.next=head2;
        if(head2==null) currNode.next=head1;
        return head.next;
    }
}

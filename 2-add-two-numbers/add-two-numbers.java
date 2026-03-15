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
class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;
        while(l1!=null||l2!=null||carry!=0){
            int x = (l1!=null)?l1.val:0;
            int y = (l2!=null)?l2.val:0;
            int sum = carry+x+y;
            carry = sum/10;
            curr.next = new ListNode(sum%10);
            curr = curr.next;
            if(l1!=null) l1 = l1.next;
            if(l2!=null) l2 = l2.next;
        }
        return dummyHead.next;
    }
    public ListNode addTwoNumbersInitial(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode();
        ListNode node = temp;
        int carry = 0;
        while(l1!=null && l2!=null){
            int curr = l1.val+l2.val+carry;
            if(curr>9){
                carry= curr/10;
                curr = curr%10;
            }else{
                carry=0;
            }
            node.next = new ListNode(curr);
            node = node.next;
            l1=l1.next;
            l2=l2.next;
        }
        if(l1!=null) node.next =l1;
        else node.next = l2;
        if(node!=null)node=node.next;
        ListNode prev = l1;
        while(node!=null){
            prev=node;
          int curr= node.val+carry;
          if(curr>9){
                carry= curr/10;
                curr = curr%10;
            }
            node.val=curr;
            node=node.next;
        }
        if(carry!=0) prev.next=new ListNode(carry);
        return temp.next;
    }
}
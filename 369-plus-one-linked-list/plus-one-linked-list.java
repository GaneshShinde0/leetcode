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
    public ListNode plusOneDoesNotWork(ListNode head) {
        ListNode temp = new ListNode(1);
        temp.next = head;
        while(head!=null){
            if(head.next==null){
                int sum = head.val+1;
                if(sum<10){
                    head.val = sum;
                }else{
                    head.val=1;
                    head.next = new ListNode(0);
                    head= head.next;
                }
            }
            head=head.next;
        }
        return temp.next;
    }

    
    public ListNode plusOne(ListNode head) {
        Stack<ListNode> stk = new Stack<>();
        ListNode temp = new ListNode(0);
        temp.next = head;
        while(head!=null){
            stk.add(head);
            head = head.next;
        }
        int carry = 1;
        while(!stk.isEmpty()){
            ListNode curr = stk.pop();
            int sum = curr.val+carry;
            if(sum<10){
                curr.val = sum;
                return temp.next;
            }else{
                curr.val = sum%10;
                carry = sum/10;
            }
        }
        if(carry!=0){
            ListNode node = new ListNode(carry);
            node.next = temp.next;
            return node;
        }
        return temp.next;
    }
}
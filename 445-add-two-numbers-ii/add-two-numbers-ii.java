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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stk1 = new Stack<>();
        Stack<Integer> stk2 = new Stack<>();
        while(l1!=null){
            stk1.add(l1.val);
            l1 = l1.next;
        }
        while(l2!=null){
            stk2.add(l2.val);
            l2 = l2.next;
        }
        int carry = 0, sum = 0;
        ListNode result = null;
        while(!stk1.isEmpty() && !stk2.isEmpty()){
            sum = stk1.pop()+stk2.pop()+carry;
            carry = sum/10;
            ListNode curr = new ListNode(sum%10);
            curr.next = result;
            result = curr;
        }

        while(!stk1.isEmpty()){
            sum = stk1.pop()+carry;
            carry = sum/10;
            ListNode curr = new ListNode(sum%10);
            curr.next = result;
            result = curr;
        }
        while(!stk2.isEmpty()){
            sum = stk2.pop()+carry;
            carry = sum/10;
            ListNode curr = new ListNode(sum%10);
            curr.next = result;
            result = curr;
        }

        if(carry>0){
            ListNode curr = new ListNode(carry);
            curr.next = result;
            result = curr;
        }
        return result;
    }
}
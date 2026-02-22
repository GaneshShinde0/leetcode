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
    public ListNode addTwoNumbersUsingStack(ListNode l1, ListNode l2) {
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

    private ListNode reverseList(ListNode head){
        ListNode prev = null, temp;
        while(head!=null){
            // Keep the next node.
            temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode r1 = reverseList(l1);
        ListNode r2 = reverseList(l2);

        int totalSum = 0, carry  = 0;
        ListNode ans = new ListNode();
        while(r1!=null || r2!=null){
            if(r1!=null){
                totalSum += r1.val;
                r1 = r1.next;
            }
            if(r2!=null){
                totalSum +=r2.val;
                r2=r2.next;
            }
            ans.val = totalSum%10;
            carry = totalSum/10;
            ListNode head = new ListNode(carry);
            head.next = ans;
            ans = head;
            totalSum = carry;
        }
        return carry == 0?ans.next:ans;
    }
}
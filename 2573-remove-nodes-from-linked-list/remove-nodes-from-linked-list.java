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
    // 78ms
    public ListNode removeNodesStack(ListNode head) {
        ListNode curr = head;
        Stack<ListNode> stk = new Stack<>();
        while(curr!=null){
            while(!stk.isEmpty() && stk.peek().val<curr.val){
                stk.pop();
            }
            stk.push(curr);
            curr = curr.next;
        }

        // Reversing the stack.
        ListNode next = null;
        while(!stk.isEmpty()){
            curr = stk.pop();
            curr.next = next;
            next = curr;
        }
        return curr;
    }
    // 15ms
    public ListNode removeNodesRecursion(ListNode head){
        if(head == null) return null; // Base condition for recursion
        ListNode node = head;
        ListNode nextGreater = removeNodesRecursion(node.next);
        node.next = nextGreater;
        if(nextGreater==null || node.val>=nextGreater.val) return node;
        return nextGreater;
    }

    // 5ms Reverse And Filter Approach
    public ListNode removeNodes(ListNode head){
        ListNode prev = null, curr = head;
        // Reverse
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        curr = prev;
        
        while(curr!=null){
            if(curr.val>=temp.val){
                temp.next = curr;
                temp = curr;
                curr = curr.next;
            }else{
                curr = curr.next;
            }
        }

        temp.next = null;

        ListNode newPrev = null, newCurr = dummy.next;
        while(newCurr!=null){
            ListNode next = newCurr.next;
            newCurr.next = newPrev;
            newPrev = newCurr;
            newCurr = next;
        }
        return newPrev;
    }
}
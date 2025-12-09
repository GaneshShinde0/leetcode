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
    public ListNode reverseListInitial(ListNode head) {
        if(head==null) return null;
        Stack<ListNode> stk = new Stack<>();
        while(head.next!=null){
            stk.add(head);
            head = head.next;
        }
        stk.add(head);
        ListNode temp = new ListNode(-1);
        ListNode curr=temp;
        while(!stk.isEmpty()){
            curr.next = stk.pop();
            curr=curr.next;
            curr.next = null; // ImportantToAvoidCycles
        }
        return temp.next;
    }

    // Iterative Inplace
    public ListNode reverseListIterative(ListNode head){
        ListNode prev = null;
        while(head!=null){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head=temp;
        }
        return prev;
    }

    public ListNode reverseListOld(ListNode head){
        // Base case: Empty or single node list
        if(head==null||head.next==null){
            return head;
        }
        
        // Recursively Reverse the rest of the list
        ListNode newHead = reverseList(head.next);
        // After recursion, head.next is the last node in the reversed subList;
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        while(head!=null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

















}
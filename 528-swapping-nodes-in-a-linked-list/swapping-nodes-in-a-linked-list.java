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

 /*
Algorithm:

Lets use two more pointers first and second, denoting the nodes for swapping
1. Put slow at head, and put fast k-1 nodes aftter slow.
2. First = fast
3. If fast isn't already at the last Node, move slow and fast one node further until fast.next == null
4. second = slow
5. Swap the values of first and second.

 */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode first = head, second = head;

        for(int i=0;i<k-1;++i) fast = fast.next;
        // Save the node for swapping
        first = fast;
        // Move until the end of the list
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        second = slow; // Second isnt really neceassary we can use slow as well but improves readability.

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        
        return head;
    }
}
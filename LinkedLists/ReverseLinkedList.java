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
 
// class Solution {
//     public ListNode reverseList(ListNode head) {
//         if (head == null)  return head;
//         ListNode root = head;
//         Stack<ListNode> stack = new Stack<>();
//         while(root!=null){
//             stack.push(root);
//             root= root.next;
//         }

//         ListNode newHead = stack.pop();
//         root=newHead;
//         while(!stack.isEmpty()){
//             root.next = stack.pop();
//             root = root.next;
//         }
//         root.next = null;
//         return newHead;

//     }
// }

class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            ListNode nextTemp = curr.next;  // Store the next node
            curr.next = prev;               // Reverse the link
            prev = curr;                    // Move prev to current node
            curr = nextTemp;                // Move to the next node
        }
        
        return prev;  // prev is the new head of the reversed list
    }
}

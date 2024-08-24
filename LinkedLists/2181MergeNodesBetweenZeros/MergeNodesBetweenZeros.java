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
class MergeNodesBetweenZeros {
    public ListNode mergeNodes(ListNode head) {
        
        // Initialize dummy node
        ListNode dummy = head.next;
        ListNode sumNode = dummy;

        while(sumNode !=null){
            int sum =0;

            while(sumNode.val!=0){
                sum+=sumNode.val;
                sumNode = sumNode.next;
            }

            // Assign the value of the sum to the current Node.
            dummy.val = sum;
            // Move the sumNode to the next non-zero value
            sumNode = sumNode.next;
            // Move dummy node to next non-zero;
            dummy.next = sumNode;
            dummy = dummy.next;
        }
        return head.next;
    }
}

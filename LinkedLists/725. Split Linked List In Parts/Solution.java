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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] nodes = new ListNode[k];
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int count = 0; // Might have to increment later.
        while(dummy!=null){
            dummy = dummy.next;
            count++;
        }
        dummy = head;
        ListNode prev = null;

        int partSize = count/k;
        int remainder = count%k-1;
        int index =0;
        while(index <k){
            ListNode tempNode = new ListNode(0);
            tempNode.next = dummy;
            if(tempNode.next == null){
                nodes[index] = dummy;
                index++;
                continue;
            }
            nodes[index] = tempNode.next;
            int temp = 0;
            if(remainder>0) {
                temp =1;
                remainder--;
            }
            for(int i=0;i<partSize+temp && dummy!=null;i++){
                tempNode = tempNode.next;
                dummy=dummy.next;
            }
            if(tempNode!=null) tempNode.next = null;
            index++;
        }
        return nodes;
    }

    public ListNode[] splitListToPartsRefactored(ListNode head, int k) {
        ListNode[] nodes = new ListNode[k];
        
        // Count the total number of nodes in the linked list.
        int count = 0;
        ListNode curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        
        // Calculate the size of each part and the remainder.
        int partSize = count / k;
        int remainder = count % k;

        curr = head;
        for (int i = 0; i < k; i++) {
            ListNode partHead = curr;
            ListNode prev = null;
            
            // Determine the current part size.
            int currentPartSize = partSize + (remainder > 0 ? 1 : 0);
            remainder--;
            
            // Move to the end of the current part.
            for (int j = 0; j < currentPartSize; j++) {
                prev = curr;
                if (curr != null) {
                    curr = curr.next;
                }
            }
            
            // Detach the current part from the rest of the list.
            if (prev != null) {
                prev.next = null;
            }
            
            // Add the current part to the result array.
            nodes[i] = partHead;
        }
        
        return nodes;
    }
}

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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0,head);
        ListNode curr = dummy;
        int prefixSum = 0;
        Map<Integer, ListNode> prefixSumToNode = new HashMap<>();
        while(curr!=null){
            prefixSum += curr.val;
            if(prefixSumToNode.containsKey(prefixSum)){
                ListNode prev = prefixSumToNode.get(prefixSum);
                curr = prev.next;
                
                int p = prefixSum+curr.val;
                while(p!=prefixSum){
                    prefixSumToNode.remove(p);
                    curr = curr.next;
                    p+= curr.val;
                }
                prev.next =curr.next;
            }else{
                prefixSumToNode.put(prefixSum, curr);
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int start = -1, end = -1, currPtr = 1, minDistance = Integer.MAX_VALUE;
        ListNode currNode = new ListNode(-1);
        currNode.next = head;
        currNode = currNode.next;
        while(currNode.next!=null){
            ListNode prev = currNode;
            currNode = currNode.next;
            if(currNode.next==null) break;
            if((currNode.next.val> currNode.val && prev.val>currNode.val)
                ||(currNode.next.val<currNode.val && prev.val<currNode.val)){
                if(start == -1){
                    start = currPtr;
                }else{
                    minDistance = Math.min(currPtr-end,minDistance);
                }
                end = currPtr;
            }
            currPtr++;
        }
        return new int[]{minDistance==Integer.MAX_VALUE?-1:minDistance, end-start==0?-1:end-start};

    }
}
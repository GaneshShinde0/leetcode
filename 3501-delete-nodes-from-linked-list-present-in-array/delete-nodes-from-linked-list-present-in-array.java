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
    public ListNode modifiedList(int[] nums, ListNode head) {
        if(head==null) return null;
        Set<Integer> set = new HashSet<>();
        for(int i:nums) set.add(i);
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(head!=null){
            if(!set.contains(head.val)){
                dummy.next = head;
                dummy = dummy.next;
            }
            head = head.next;

        }
        dummy.next = null;
        return temp.next;
    }
}
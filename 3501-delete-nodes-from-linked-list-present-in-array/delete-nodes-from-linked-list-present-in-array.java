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
    public ListNode modifiedListInitial(int[] nums, ListNode head) {
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
    public ListNode modifiedList(int[] nums, ListNode head) {
        int max = -1;
        for(int num : nums ){
            max = num > max ? num : max;
        }
        boolean[] freq = new boolean[max+1];

        for(int num : nums) freq[num] = true;

        ListNode temp = new ListNode(-1);
        ListNode current = temp;

        while(head != null){
            if( head.val >= freq.length || freq[head.val] == false){
                current.next = head;
                current = current.next;
            }
            head = head.next;
        }

        current.next = null;
        return temp.next;
    }
}
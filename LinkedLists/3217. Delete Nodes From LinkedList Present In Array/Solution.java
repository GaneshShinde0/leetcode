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
    public ListNode modifiedList01(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for(int i:nums){
            set.add(i);
        }

        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode dummy = temp;
        while(set.contains(dummy.val)){
            if (set.contains(dummy.val)) dummy = dummy.next;
        }

        while(dummy.next!=null){
            if(set.contains(dummy.next.val)) dummy.next=dummy.next.next;
            else dummy = dummy.next;
        }
        return temp.next;
    }

    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for(int i:nums){
            set.add(i);
        }

        ListNode temp = new ListNode(0,head);
        ListNode dummy = temp;
        

        while(dummy.next!=null){
            if(set.contains(dummy.next.val)) dummy.next=dummy.next.next;
            else dummy = dummy.next;
        }
        return temp.next;
    }
}

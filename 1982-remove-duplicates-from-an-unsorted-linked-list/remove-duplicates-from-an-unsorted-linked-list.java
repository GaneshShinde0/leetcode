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

    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        if (head == null) return null;

        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();

        // 1. First pass: find duplicates
        ListNode curr = head;
        while (curr != null) {
            if (!seen.add(curr.val)) {
                duplicates.add(curr.val);
            }
            curr = curr.next;
        }

        // 2. Second pass: build list without duplicates
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        curr = head;

        while (curr != null) {
            if (duplicates.contains(curr.val)) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }

        return dummy.next;
    }
    
    public ListNode deleteDuplicatesUnsortedInitial(ListNode head) {
        Set<Integer> setAll = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();
        ListNode temp = new ListNode(-1);
        ListNode res = temp;
        res.next = head;
        while(res!=null){
            if(setAll.contains(res.val)) duplicates.add(res.val);
            setAll.add(res.val);
            res = res.next;
        }
        res = temp.next;
        ListNode prev = temp;
        // System.out.println(duplicates);
        while(prev.next!=null){
            if(duplicates.contains(prev.next.val)){
                prev.next=prev.next.next;
            }else{
                prev = prev.next;
            }
        }
        return temp.next;
    }
}
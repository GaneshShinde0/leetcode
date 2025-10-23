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
    public ListNode frequenciesOfElements(ListNode head) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        while(head!=null){
            int temp = head.val;
            hm.put(temp, hm.getOrDefault(temp,0)+1);
            head = head.next;
        }
        ListNode res = new ListNode(-1);
        ListNode temp = res;
        for(Map.Entry<Integer,Integer> e: hm.entrySet()){
            temp.next = new ListNode(e.getValue());
            temp = temp.next;
        }
        return res.next;
    }
}
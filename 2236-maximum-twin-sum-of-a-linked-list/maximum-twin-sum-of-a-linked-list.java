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
    public int pairSum(ListNode head) {
        int i = 0;
        List<Integer> li = new ArrayList<>();
        while(head!=null){
            li.add(head.val);
            head = head.next;
        }
        int res = 0, left = 0, right = li.size()-1;
        while(left<right){
            res = Math.max(li.get(left++)+li.get(right--), res);
        }
        return res;
    }
}
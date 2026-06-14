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
    public int pairSumInitial(ListNode head) {
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
    
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode next, prev = null;
        while(slow!=null){
            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        ListNode start = head;
        int maxSum = 0;
        while(prev!=null){
            maxSum = Math.max(maxSum, start.val+prev.val);
            prev = prev.next;
            start = start.next;
        }
        return maxSum;
    }
}
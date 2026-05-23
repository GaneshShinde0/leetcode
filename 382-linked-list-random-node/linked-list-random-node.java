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
    Random random;
    HashMap<Integer, Integer> hm = new HashMap<>();
    int count = 0;
    public Solution(ListNode head) {
        this.random = new Random();
        while(head!=null){
            hm.put(count,head.val);
            head = head.next;
            count++;
        }
    }
    
    public int getRandom() {
        return hm.get(random.nextInt(count));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
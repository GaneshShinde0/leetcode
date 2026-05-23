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
class Solution1 {
    Random random;
    HashMap<Integer, Integer> hm = new HashMap<>();
    int count = 0;
    public Solution1(ListNode head) {
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
// Reservoir Sampling
class Solution {
    Random random;
    HashMap<Integer, Integer> hm = new HashMap<>();
    int count = 0;
    ListNode head;
    public Solution(ListNode head) {
        this.random = new Random();
        this.head=head;
    }
    
    public int getRandom() {
        int chosenValue = 0, i = 1;
        ListNode tempNode = head;
        while(tempNode != null){
            if(random.nextInt(i) == 0) chosenValue=tempNode.val;
            tempNode = tempNode.next;
            i++;
        }
        return chosenValue;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
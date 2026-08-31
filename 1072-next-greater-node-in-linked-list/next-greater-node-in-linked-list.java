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
class Solution{
    public int[] nextLargerNodes(ListNode head){
        Stack<int[]> stk = new Stack<>();
        List<Integer> answer = new ArrayList<>();
        int cnt = 0;

        while(head!=null){
            answer.add(0);
            while(!stk.isEmpty() && head.val>stk.peek()[1]){
                int[] curr = stk.peek();
                int id = curr[0], val = curr[1];
                stk.pop();
                answer.set(id,head.val);
            }
            stk.add(new int[]{cnt++, head.val});
            head = head.next;
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}
class SolutionTwoPass {
    public int[] nextLargerNodes(ListNode head) {
        ListNode temp = new ListNode(-1);
        temp.next = head;
        List<Integer> li = new ArrayList<>();
        while(head!=null){
            li.add(head.val);
            head = head.next;
        }
        int n = li.size();
        int[] res = new int[li.size()];
        Stack<Integer> stk = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!stk.isEmpty() && stk.peek()<=li.get(i)) stk.pop();
            res[i] = stk.isEmpty()?0:stk.peek();
            stk.push(li.get(i));
        }
        return res;
    }
}
/*
Maximum Twin Sum
Sum of 
Ni + N-i-1 => Find Max of all sum;
*/
class Solution {
    public int pairSum(ListNode head) {
        int ans = 0;
        ListNode newList = null;
        ListNode current = head;
        ListNode currHalf = head;


        while(currHalf!=null && currHalf.next!=null){
            currHalf = currHalf.next.next; // Fast Pointer
            ListNode temp = current.next; // Current Next
            current.next = newList; // We are basically swapping two nodes in list using third pointer.
            newList = current;
            current = temp;
        }
        while(current!=null){
            ans = Math.max(ans,current.val+newList.val);
            current = current.next;
            newList = newList.next;
        }
        return ans;
    }
}
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

// We can basically do merge sort as lists are already sorted. 
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        int j = 0;
        int currSize = n;
        if(lists==null || lists.length==0) return null;
        while(currSize>1){
            for(int i=0;i<currSize-1;i+=2){
                ListNode l1 = lists[i];
                ListNode l2 = lists[i+1];
                lists[j] = mergeList(l1,l2);
                j++;
            }
            if(currSize%2==1 && currSize!=1){
                lists[0] = mergeList(lists[0],lists[currSize-1]);
            }
            currSize/=2;
            j = 0;
        }
        return lists[0];
    }
    private ListNode mergeList(ListNode l1, ListNode l2){
        ListNode root = new ListNode(-1);
        ListNode node = root;
        if(l1==null) return l2;
        while(l1!=null && l2!=null){
            if(l1.val>=l2.val){
                node.next = l2;
                l2 = l2.next;
            }else{
                node.next = l1;
                l1 = l1.next;
            }
            node = node.next;
        }
        if(l1!=null) node.next = l1;
        else node.next = l2;

        return root.next;
    }
}
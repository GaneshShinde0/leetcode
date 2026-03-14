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

 /*
# Intuition

Insertion Sort Algorithm:
- First of all, we create an empty list which could be used to hold the result of sorting.
- We then iterate throgh each element in the input list. For each element, we need to find a proper position in the resulting list to insert the element, so that the order of the resulting list is maintained.
- As one can see, once the iteration in the above step terminates, we will obtain the resulting list where elements are sorted. 

Example, by applying the above intuition.

Given the input list input = [4, 3, 5] we have initially an empty resulting lsit result = [].
- We then iterate over the input list. For the first element 4, we need to find a proper position in the resulting list to place it.
Since the resulting list is still empty, we then simply append it to the resulting list, i.e. result = [4]
- Now fo the second element i.e. 3 in the input list, similarly we need to insert it properly into the resulting list.
    - As one can see, we need to insert it right before the element 4.
    - As a result, the resulting list becomes [3,4].
- Finally, for the last element (i.e. 5) in the input list, as it turns out, the proper position to placce it is the tail of the resulting list.
- With this last iteration we obtain a sorted list as result = [3,4,5].

Algorithm:

To translate above intuition into the implementation, we applied two tricks.

    First trick is that we will create a dummy (pseudo_head) node which serves as a pointer pointing to the resulting list.

More precisely, this node facilitates us to always get a hold on the resulting list, especially when we need to insert a new element to the head of the resulting list. 

In a singly- linked list, each node has only one pointer that points to the next node.
If we would like to insert a new node (say B) before certain node (say A), we need to know the node (Say C) that is currently before the node A, i.e. C-> A.

With the reference in the node C, we could now insert the new node, i.e. C-> B-> A.

Given the above insight, in order to tinsert a new lement into a singly-linked list, we apply another trick.

    The idea is that we use a pair of pointers (namely prev-> next) which serve as placeholders to guard the position where in-between we would insert a new element (i.e. prev -> newNode -> next).

With the same example before, i.e., input = [4,3,5], we illustrate what the above helper pointer look like at the momemt of insertion, in the following graph.



 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode curr = head;

        while(curr!=null){
            // At each iteration we insert an element into the resulting list.
            ListNode prev = dummy;

            // Find the position to insert the current value/node.
            while(prev.next!=null && prev.next.val<=curr.val){
                prev = prev.next;
            }

            ListNode next = curr.next;
            // Insert the current node to the new list
            curr.next = prev.next;
            prev.next = curr;

            // Moving on to the next iteration
            curr = next;
        }
        return dummy.next;
    }
}
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
        ListNode dummy = new ListNode(0 );
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
/*
Dry Run:
Input: 4 -> 5 -> 1 -> 13 -> 2
Sorted (Dummy): 0 -> null

Iter 1: Curr = 4

Scan: prev starts at Dummy(0). Next(null) is end. Stop.
Insert: 4 after 0.
List: 0 -> 4
Iter 2: Curr = 5

Scan: prev at 0. Next(4) < 5. Move prev to 4.
Insert: 5 after 4.
List: 0 -> 4 -> 5
Iter 3: Curr = 1

Scan: prev at 0. Next(4) > 1. Stop at 0.
Insert: 1 after 0.
List: 0 -> 1 -> 4 -> 5
Iter 4: Curr = 13

Scan: prev moves past 1, 4, 5 (all < 13). Stop at 5.
Insert: 13 after 5.
List: 0 -> 1 -> 4 -> 5 -> 13
Iter 5: Curr = 2

Scan: prev moves past 1. Next(4) > 2. Stop at 1.
Insert: 2 after 1.
List: 0 -> 1 -> 2 -> 4 -> 5 -> 13
Result: 1 -> 2 -> 4 -> 5 -> 13
*/
/*
Complexity Analysis:

Let N be the nubmer of elements in the input list.

- Time Complexity: O(N^2)
    - First of all, we run an iteration over the input list.
    - At each iteration, we insert an element into the resulting list. In the worst case where position to insert is the tail of the list, we will have to walk through the entire resulting list.
    - As a result, the total steps that we need to walk in the worst case would be n(n+1)/2
    - To sum up, the overall time complexity of the algorithm is O(N^2)/

- Spacce Complexity: O(1)
    - We used some pointers whithin the algorithm. However, their memory consumption is constant regardless of the input.
    - Note, we did not create new nodes to hold the values of input list, but simply reorder the existing nodes.

*/
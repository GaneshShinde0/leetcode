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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution1 {
    public TreeNode sortedListToBSTRevisitLater(ListNode head) {
        Stack<TreeNode> stk = new Stack<>();
        TreeNode root = null;
        while(head!=null){
            TreeNode node = new TreeNode(head.val);
            if(stk.isEmpty()){
                stk.push(node);
                head = head.next;
            }else{
                if(stk.peek().val<head.val){
                    node.left = stk.pop();
                    stk.push(node);
                }else{
                    root = stk.peek();
                    root.right = node;
                    root = root.right;
                }
            }
        }
        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        if(head.next==null) return new TreeNode(head.val);
        ListNode midNode = getMiddle(head);
        TreeNode mid = new TreeNode(midNode.val);
        ListNode temp= midNode.next;
        mid.left = sortedListToBST(head);
        mid.right = sortedListToBST(temp);
        return mid;
    }

    public ListNode getMiddle(ListNode head){
        ListNode fast = head, slow = head,prev=null;
        while(fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(prev!=null) prev.next=null;
        return slow;
    }
}

class Solution{
    private ListNode head;

    private int findSize(ListNode head){
        ListNode temp = head;
        int n = 0;
        while(temp!=null){
            temp=temp.next;
            n++;
        }
        return n;
    }

    private TreeNode convertListToBST(int l, int r){
        if(l>r) return null;
        int mid = (l+r)/2;
        TreeNode left = convertListToBST(l,mid-1);
        TreeNode node = new TreeNode(this.head.val);
        node.left = left;
        this.head = this.head.next;
        node.right = this.convertListToBST(mid+1,r);
        return node;
    }

    public TreeNode sortedListToBST(ListNode head){
        int size = findSize(head);
        this.head = head;
        return convertListToBST(0,size-1);
    }
}
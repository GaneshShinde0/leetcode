/*
Intuition:
- Lets simulate traversal.
- Keeping a stack of nodes, of whcih we're still in the left subtree, if the next number is smaller than the last stack value, then we're still in the left subtree of all the stack node, so we will push new node onto the stack.
- But before that, pop all smaller ancestor values as we must now be in the right subtrees (or evern further, -> RIght subtree of an ancestor). Also, use the popped values as a lower bound, since being in their right subtree means we must never come across a smaller number anymore.
*/
class Solution {
    public boolean verifyPreorder(int[] preOrder) {
        int low = Integer.MIN_VALUE;
        Stack<Integer> path = new Stack<>();
        for(int p:preOrder){
            if(p<low) return false;
            while(!path.isEmpty() && p>path.peek()) low = path.pop();
            path.push(p);
        }
        return true;
    }
}
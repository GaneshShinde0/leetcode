/*
Intuition:
- Lets simulate traversal.
- Keeping a stack of nodes, of whcih we're still in the left subtree, if the next number is smaller than the last stack value, then we're still in the left subtree of all the stack node, so we will push new node onto the stack.
- But before that, pop all smaller ancestor values as we must now be in the right subtrees (or evern further, -> RIght subtree of an ancestor). Also, use the popped values as a lower bound, since being in their right subtree means we must never come across a smaller number anymore.
*/
/*
Input: preorder = [5,2,1,3,6]

Initially
low = -1;
path = []

p = 5
path = [5]
low = -1

p=2
path = [5,2]
low = -1;

p=1
path = [5,2,1]
low = -1;

p= 3 =>p>path.peek()=>3>1
low = 1
path = [5,2,3]

p = 6 => 6>3=>
low = 3
path = [5,2,6]

return true;



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
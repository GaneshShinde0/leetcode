// class Node {
//     public boolean val;
//     public boolean isLeaf;
//     public Node topLeft;
//     public Node topRight;
//     public Node bottomLeft;
//     public Node bottomRight;

    
//     public Node() {
//         this.val = false;
//         this.isLeaf = false;
//         this.topLeft = null;
//         this.topRight = null;
//         this.bottomLeft = null;
//         this.bottomRight = null;
//     }
    
//     public Node(boolean val, boolean isLeaf) {
//         this.val = val;
//         this.isLeaf = isLeaf;
//         this.topLeft = null;
//         this.topRight = null;
//         this.bottomLeft = null;
//         this.bottomRight = null;
//     }
    
//     public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
//         this.val = val;
//         this.isLeaf = isLeaf;
//         this.topLeft = topLeft;
//         this.topRight = topRight;
//         this.bottomLeft = bottomLeft;
//         this.bottomRight = bottomRight;
//     }
// }


class Solution {
    public Node construct(int[][] grid) {
        return recurse(grid,0,0,grid.length);
    }
    public Node recurse(int[][] grid,int start,int end,int n){
        if(n==1) return new Node(grid[start][end]==1,true);
        
        Node topLeft = recurse(grid,start,end,n/2);
        Node topRight = recurse(grid,start,end+n/2,n/2);
        Node bottomLeft = recurse(grid,start+n/2,end,n/2);
        Node bottomRight = recurse(grid,start+n/2,end+n/2,n/2);
        
        
        // If the four returned nodes are leaf and have the same values
        // Return a leaf node with the same value.
        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf
                && topLeft.val == topRight.val && topRight.val == bottomLeft.val
                && bottomLeft.val == bottomRight.val) {
            return new Node(topLeft.val, true);
        }

        return new Node(false,false,topLeft,topRight,bottomLeft,bottomRight);
        
    }
}
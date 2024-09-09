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
class SpiralMatrix4 {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int i=0,j=0,currentDirection=0;
        int[][] res = new int[m][n];
        int[][] directions = {
            {0,1}, // Column is incrementing
            {1,0}, // Row is incrementing
            {0,-1}, // Column is decrementing
            {-1,0} // Row is decrementing 
        };
        
        for(int[] row:res){
            Arrays.fill(row,-1);
        }
        while(head!=null){
            res[i][j] = head.val;
            head = head.next;

            int newi = i+directions[currentDirection][0];
            int newj = j+directions[currentDirection][1];

            if(
                Math.min(newi,newj)<0||
                newi>=m||
                newj>=n||
                res[newi][newj] != -1
            ) currentDirection = (currentDirection+1)%4;

            i+=directions[currentDirection][0];
            j+=directions[currentDirection][1];
            
        }
        return res;
    }
}

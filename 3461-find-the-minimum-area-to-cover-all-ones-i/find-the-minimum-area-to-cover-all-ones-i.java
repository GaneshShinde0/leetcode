class Solution {
    public int minimumArea(int[][] grid) {
        int top=Integer.MAX_VALUE,bottom=0, left=Integer.MAX_VALUE, right=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    top = Math.min(i,top);
                    bottom = Math.max(i,bottom);
                    left = Math.min(j, left);
                    right = Math.max(j,right);
                }
            }
        }
        if(top==Integer.MAX_VALUE) return 0;
        // System.out.println("Top:"+top+",Bottom:"+bottom);
        // System.out.println("Left:"+left+",Right:"+right);
        return (right-left+1)*(bottom-top+1);
    }
}
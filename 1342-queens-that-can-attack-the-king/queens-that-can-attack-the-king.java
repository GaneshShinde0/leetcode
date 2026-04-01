class Solution {
    int[][] dirs = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        boolean[][] queenPos = new boolean[8][8];
        List<List<Integer>> result = new ArrayList<>();
        for(int[] q:queens) queenPos[q[0]][q[1]] = true;
        for(int[] dir:dirs){
            int i= king[0];
            int j= king[1];
            int nI = i+dir[0];
            int nJ = j+dir[1];
            while(nI>=0 && nJ>=0 && nI<8 && nJ<8){
                if(queenPos[nI][nJ]){
                    result.add(List.of(nI,nJ));
                    break;
                }
                nI = nI+dir[0];
                nJ = nJ+dir[1];
            }
        }
        return result;
    }
}
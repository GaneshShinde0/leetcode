class Solution {
    public int maxScore(List<List<Integer>> grid) {
        int m = grid.size(), n = grid.get(0).size();
        int res = Integer.MIN_VALUE;
        int MAX = 10000000;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int pre = Math.min(
                    i>0? grid.get(i-1).get(j) : MAX,
                    j>0?grid.get(i).get(j-1) : MAX
                );
                res = Math.max(res, grid.get(i).get(j)-pre);
                if(pre<grid.get(i).get(j)){
                    grid.get(i).set(j,pre);
                }
            }
        }
        return res;        
    }
}

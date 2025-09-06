class Solution {
    public int equalPairs(int[][] grid) {
        Map<String,Integer> hm = new HashMap<>();
        int n = grid.length;
        int result = 0;
        for(int[] arr:grid){
            hm.put(Arrays.toString(arr),hm.getOrDefault(Arrays.toString(arr),0)+1);
        }
        for(int j=0;j<n;j++){
            int[] column = new int[n];
            for(int i=0;i<n;i++){
                column[i]=grid[i][j];
            }
            if(hm.containsKey(Arrays.toString(column))) result+=hm.get(Arrays.toString(column));
        }
        return result;
    }
}
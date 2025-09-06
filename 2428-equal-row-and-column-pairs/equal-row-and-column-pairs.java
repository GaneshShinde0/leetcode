class Solution {
    public int equalPairs(int[][] grid) {
        Map<String,Integer> hm = new HashMap<>();
        String s = "";
        int n = grid.length;
        int result = 0;
        for(int[] arr:grid){
            s= Arrays.toString(arr);
            hm.put(s,hm.getOrDefault(s,0)+1);
        }
        for(int j=0;j<n;j++){
            int[] column = new int[n];
            for(int i=0;i<n;i++){
                column[i]=grid[i][j];
            }
            s = Arrays.toString(column);
            if(hm.containsKey(s)) result+=hm.get(s);
        }
        return result;
    }
}
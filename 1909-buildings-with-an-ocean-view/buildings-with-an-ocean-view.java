class Solution {
    public int[] findBuildings(int[] heights) {
        List<Integer> li = new ArrayList<>();
        int rightMax = 0, n = heights.length;
        for(int i=n-1;i>=0;i--){
            if(heights[i]>rightMax) li.add(i);
            rightMax = Math.max(rightMax, heights[i]);
        }
        int m = li.size();
        int[] res = new int[m];
        for(int i=0;i<m;i++){
            res[i] = li.get(m-i-1);
        }
        return res;
    }
}
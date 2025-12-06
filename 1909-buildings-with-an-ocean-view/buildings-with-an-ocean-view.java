class Solution {
    public int[] findBuildings(int[] heights) {
        List<Integer> li = new ArrayList<>();
        int n = heights.length;
        li.add(n-1);
        int max = n-1;
        for(int i=n-2;i>=0;i--){
            if(heights[i]>heights[max]){
                max = i;
                li.add(i);
            }
        }
        int[] res = new int[li.size()];
        int resSize = li.size();
        for(int i=0;i<resSize;i++){
            res[i]=li.get(resSize-1-i);
        }
        return res;
    }
}
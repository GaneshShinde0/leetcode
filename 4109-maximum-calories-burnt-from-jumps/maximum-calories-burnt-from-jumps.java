class Solution {
    public long maxCaloriesBurnt(int[] heights) {
        Arrays.sort(heights);
        int n = heights.length;
        long res = 0l;
        int left = 0, right = heights.length-1;
        long prev = 0;
        while(left<=right){
            long currLeft = (prev-heights[left])*(prev-heights[left]);
            long currRight = (prev-heights[right])*(prev-heights[right]);
            if(currLeft>currRight){
                res+=currLeft;
                prev = heights[left];
                left++;
            }else{
                res+=currRight;
                prev=heights[right];
                right--;
            }
        }
        return res;
    }
}
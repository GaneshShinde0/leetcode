class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int start = 0, end = n-1;
        int res = Integer.MIN_VALUE;
        while(start<end){
            int width = end-start;
            int currHeight = Math.min(height[start],height[end]);
            res = Math.max(res, width*currHeight);
            if(height[end]>height[start]){
                start++;
            }else{
                end--;
            }
        }
        return res;
    }
}
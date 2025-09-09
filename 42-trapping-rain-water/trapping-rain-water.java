class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftHeight = new int[n];
        int[] rightHeight = new int[n];
        int res = 0;
        leftHeight[0]=height[0];
        rightHeight[n-1]=height[n-1];
        for(int i=1;i<n;i++){
            leftHeight[i]=Math.max(height[i],leftHeight[i-1]);
            rightHeight[n-i-1]=Math.max(height[n-i-1],rightHeight[n-i]);
        }
        for(int i=0;i<n;i++){
            res+=Math.min(leftHeight[i],rightHeight[i])-height[i];
        }
        return res;
    }
}
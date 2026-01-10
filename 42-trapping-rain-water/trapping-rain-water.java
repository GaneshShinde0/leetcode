/*
Input: height = [4,2,0,3,2,5]
Left: height = [4,4,4,4,4,5]
Right: height = [5,5,5,5,5,5]
0,2,4,1,2
*/

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = height[0];
        rightMax[n-1] = height[n-1];
        for(int i=1;i<n;i++){
            leftMax[i] = Math.max(leftMax[i-1],height[i]);
        }
        for(int i=n-2;i>=0;i--){
            rightMax[i] = Math.max(rightMax[i+1],height[i]);
        }

        int res = 0;
        for(int i=0;i<n;i++){
            res+=Math.min(leftMax[i],rightMax[i])-height[i];
        }
        return res;
    }
}
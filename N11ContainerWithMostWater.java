class N11ContainerWithMostWater {
    public int maxAreaNaive(int[] height) {
        int water=0;
        int length= height.length;
        for(int i=0;i<length;i++){
            for(int j=i+1;j<length;j++){
                if(Math.min(height[i],height[j])*(j-i)>water){
                    water =Math.min(height[i],height[j])*(j-i);
                }
            }
        }
        return water;
    }

    public int maxAreaTakes4MS(int[] height) {
        int water =0;
        int left=0;
        int length = height.length;
        int right = height.length-1;
        while(right>left){
            int min=Math.min(height[left],height[right]);
            if(min*(right-left)>water){
                water =min*(right-left);
            }          
            if(height[left]<height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return water;
    }

    public int maxArea(int[] height) {
        int water =0;
        int left=0;
        int min=0;
        int right = height.length-1;
        while(right>left){
            min=Math.min(height[left],height[right]);
            if(min*(right-left)>water){
                water =min*(right-left);
            }          
            while(left<right&&height[left]<=min){
                left++;
            }
            while(left<right&&height[right]<=min){
                right--;
            }
        }
        return water;
    }
    public int maxArea2MS(int[] height) {
        int max = 0;
        int l = 0;
        int r = height.length - 1;
        int calc = 0;
        int minNum = 0;
        
        while (l < r) {
            minNum = Math.min(height[l], height[r]);
            calc = (minNum) * (r - l);
            max = Math.max(max, calc);

            // Skip all the values which are less than or equal to minNum
            while (l < r && height[l] <= minNum) l++;
            while (l < r && height[r] <= minNum) r--;
        }
        
        return max;
    }

}

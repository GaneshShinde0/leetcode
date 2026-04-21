class Solution {
    public int[] pourWater(int[] heights, int volume, int k) {
        while(volume>0){
            int index = k;
            int left = k-1;
            // Some lower height might be present on left side.
            while(left>=0 && heights[left]<=heights[index]){
                // Heights are equal lets check more on left
                if(heights[left]==heights[index]){
                    left--;
                }else{ // We can fill droplet probably here or on left.
                    index=left;
                    left--;
                }
            }
            int right = k+1;
            // Could not fill anything on left.
            if(index==k){
                // Some lower height might be present on right side.
                while(right<heights.length && heights[right]<=heights[index]){
                    // Heights are equal lets check more on right.
                    if(heights[right]==heights[index]){
                        right++;
                    }else{ // We can fill droplet probably here or on right.
                        index = right;
                        right++;
                    }
                }
            }
            heights[index]++;
            volume--;
        }
        return heights;
    }
}
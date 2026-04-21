class Solution {
    public int[] pourWater(int[] heights, int volume, int k) {
        while(volume>0){
            int index = k;
            int left = k-1;
            while(left>=0 && heights[left]<=heights[index]){
                if(heights[left]==heights[index]){
                    left--;
                }else{
                    index=left;
                    left--;
                }
            }
            int right = k+1;
            if(index==k){
                while(right<heights.length && heights[right]<=heights[index]){
                    if(heights[right]==heights[index]){
                        right++;
                    }else{
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
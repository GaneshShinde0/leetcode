class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n= position.length, low = 0, high = (position[n-1]-position[0])/(m-1);
        while(low<high){
            int mid = low + (high-low+1)/2;
            if(canPlace(mid, m, position)){
                low = mid;
            }else{
                high = mid-1;
            }
        }
        return low;
    }

    private boolean canPlace(int mid, int balls, int[] position){
        int prev = position[0];
        int ballsPlaced = 1;
        for(int i=1;i<position.length && ballsPlaced<balls;i++){
            int curr = position[i];
            if(curr-prev>=mid){
                ballsPlaced++;
                prev = curr;
            }
        }
        return ballsPlaced==balls;
    }
}
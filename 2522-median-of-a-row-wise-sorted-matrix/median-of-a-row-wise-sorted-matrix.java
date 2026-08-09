class Solution {
    public int matrixMedian(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i=0;i<r;i++){
            min = Math.min(min, grid[i][0]);
            max = Math.max(max, grid[i][c-1]);
        }

        while(min<max){
            int mid = (min+max)/2;
            int req = (r*c+1)/2;
            int count = 0;
            for(int i=0;i<r;i++){
                count+= findLowerCount(grid[i], mid);
            }
            if(count<req){
                min = mid+1;
            }else{
                max = mid;
            }
        }
        return min;
    }

    private int findLowerCount(int[] arr, int target){
        int low = 0, high = arr.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]>target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
}
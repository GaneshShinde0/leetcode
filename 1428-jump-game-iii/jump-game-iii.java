class Solution {
    public boolean canReach(int[] arr, int start) {
        return helper(arr,start);
    }
    public boolean helper(int[] arr, int start){
        if(start<0||start>=arr.length || arr[start]==-1) return false;
        if(arr[start]==0) return true;
        int temp = arr[start];
        arr[start] = -1;
        return helper(arr,start+temp) || helper(arr,start-temp);
    }
}
/*
arr = [4,2,3,0,3,1,2], start = 5;
arr = [4,2,3,0,3,1,2], start = 5;
temp = 1;
arr = [4,2,3,0,3,-1,2], start = 4;
temp = 3
arr[]
arr = [4,2,3,0,3,-1,2], start = 6;

*/
class Solution {
    public int incremovableSubarrayCount(int[] arr) {
        var res = 0;
        for (int i=0;i<arr.length;i++){
            for (int j=i;j<arr.length;j++){
                if (isIncreasing(arr,i,j)) res++;
            }
        }
        return res;
    }
    
    public boolean isIncreasing(int[] arr, int from, int to){
        var prev = 0 ;
        for (int i=0;i<arr.length;i++){
            if (i<=to&&i>=from) continue;
            if (arr[i]<=prev) return false;
            prev=arr[i];
        }
        return true;
    }
}
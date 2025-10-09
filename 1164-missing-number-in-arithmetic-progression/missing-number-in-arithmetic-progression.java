class Solution {
    public int missingNumber(int[] arr) {
        int n = arr.length;
        int d = Integer.MAX_VALUE;
        if(Math.abs(arr[1]-arr[0])<Math.abs(arr[n-1]-arr[n-2])){
            d = arr[1]-arr[0];
        }else{
            d = arr[n-1]-arr[n-2];
        }
        for(int i=1;i<n;i++){
            if((arr[i]-arr[i-1])==2*d) return arr[i-1]+d;
        }
        return -1;
    }
}
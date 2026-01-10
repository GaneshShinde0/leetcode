class Solution {
    public int longestMountainInitialNeedsCleaninc(int[] arr) {
        int inc = 0, dec = 0,res = 0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>arr[i-1]){
                if(dec>0){
                    res = Math.max(inc+dec+1,res);
                    inc = 0;
                    dec=0;
                }
                inc++;
            }
            if(inc>0 && arr[i]<arr[i-1]) dec++;
            if(arr[i]==arr[i-1]){
                inc = 0;
                dec = 0;
            }
            if(inc>0 && dec>0)res = Math.max(inc+dec+1,res);
        }
        return res;
    }

    public int longestMountain(int[] A) {
        int res = 0, inc = 0, dec = 0;
        for (int i = 1; i < A.length; ++i) {
            if ((dec > 0 && A[i - 1] < A[i]) || A[i - 1] == A[i]) inc = dec = 0;
            if (A[i - 1] < A[i]) inc++;
            if (A[i - 1] > A[i]) dec++;
            if (inc > 0 && dec > 0 && inc + dec + 1 > res) res = inc + dec + 1;
        }
        return res;
    }
}
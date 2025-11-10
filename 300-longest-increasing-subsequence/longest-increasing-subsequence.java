class Solution {
    public int lengthOfLIS1(int[] arr) {
        int n = arr.length;
        int[] lisLength = new int[n];
        Arrays.fill(lisLength,1);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    lisLength[i] = Math.max(lisLength[j]+1,lisLength[i]);
                }
            }
        }
        int res = Integer.MIN_VALUE;
        for(int i:lisLength){
            res = Math.max(i,res);
        }
        return res;
    }
    public int lengthOfLIS(int[] arr) {
        int n = arr.length;
        int[] lisLength = new int[n];
        Arrays.fill(lisLength,1);
        for(int i=0; i<n; i++){
            for(int j=i+1;j<n;j++){
                if(arr[i]<arr[j]){
                    lisLength[j] = Math.max(lisLength[j],lisLength[i]+1);
                }
            }
        }
        int res = 0;
        for(int i:lisLength){
            res = Math.max(i,res);
        }
        return res;
    }
}
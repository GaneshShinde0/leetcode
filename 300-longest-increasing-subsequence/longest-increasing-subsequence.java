class Solution {
    public int lengthOfLIS(int[] arr) {
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
}
class Solution {
    public int[] xorQueriesSlow(int[] arr, int[][] queries) {
        int[] res = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            res[i]=getXor(arr,queries[i][0],queries[i][1]);
        }
        return res;
    }
    public int getXor(int[] arr, int i, int j){
        int xor = arr[i];
        for(int x=i+1;x<=j;x++){
            xor ^= arr[x];
        }
        return xor;
    }

    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] ans = new int[queries.length];
        int[] prefix = new int[arr.length];

        prefix[0] = arr[0];

        for(int i=1;i<arr.length;i++){
            prefix[i] = prefix[i-1]^arr[i];
        }

        for(int i=0;i<queries.length;i++){
            int start = queries[i][0];
            int end = queries[i][1];
            if(start == 0){
                ans[i] = prefix[end];
            }else{
                ans[i] = prefix[end] ^ prefix[start-1];// This works because XORing with prefix[left - 1] effectively removes the elements before left, leaving the XOR of the subarray from left to right.
            }
        }
        return ans;
    }
}

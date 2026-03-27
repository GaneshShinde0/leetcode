class Solution {
    public long[] kthPalindrome(int[] queries, int intLength) {
        int n  = queries.length;
        int base = (int) Math.pow(10,(intLength-1)/2);
        long[] res = new long[n];
        for(int i=0;i<n;i++){
            res[i] = queries[i]-1+base;
        }
        for(int i=0;i<n;i++){
            if(res[i]>=base*10){
                res[i]=-1;
                continue;
            }
            String s = String.valueOf(res[i]);
            StringBuilder sb = new StringBuilder(s);
            StringBuilder reverse = new StringBuilder(s).reverse();
            res[i] = Long.parseLong(intLength%2==1?sb.append(reverse.substring(1)).toString():sb.append(reverse).toString());
        }
        return res;
    }
}
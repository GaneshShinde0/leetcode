/*
|arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j|
- Can be represented in 8 ways if we remove modulo.
*/
class Solution {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int[] sign={-1,1};
        int res = Integer.MIN_VALUE;
        for(int s1:sign){
            for(int s2:sign){
                for(int s3:sign){
                    // max and min should be calculated using same sign;, considering sign of i-j as well
                    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
                    for(int i=0;i<arr1.length;i++){
                        int temp1 = s1*arr1[i]+s2*arr2[i]+s3*i;
                        max = Math.max(max, temp1);
                        min = Math.min(min, temp1);
                        res = Math.max(res, max-min);
                    }
                }
            }
        }
        return res;
    }
}
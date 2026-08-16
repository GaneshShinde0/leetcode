/*
|arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j|
- Can be represented in 8 ways if we remove modulo.
*/
class Solution {
    public int maxAbsValExpr(int[] x, int[] y) {
        int res = 0, n = x.length, P[] = {-1,1};
        for (int p : P) {
            for (int q : P) {
                int smallest = p * x[0] + q * y[0] + 0;
                for (int i = 1; i < n; ++i) {
                    int cur = p * x[i] + q * y[i] + i;
                    res = Math.max(res, cur - smallest);
                    smallest = Math.min(smallest, cur);
                }
            }
        }
        return res;
    }
    public int maxAbsValExprInitial(int[] arr1, int[] arr2) {
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
    public int maxAbsValExprOther(int[] arr1, int[] arr2) {
        int[] sign={-1,1};
        int res = Integer.MIN_VALUE;
        int[] max = new int[4];
        Arrays.fill(max, Integer.MIN_VALUE);
        int[] min = new int[4];
        Arrays.fill(min, Integer.MAX_VALUE);
        
        for(int i=0;i<arr1.length;i++){
            int v0,v1,v2,v3;
            v0 = arr1[i] + arr2[i] + i;
            v1 = arr1[i] - arr2[i] + i;
            v2 = -arr1[i] + arr2[i] + i;
            v3 = -arr1[i] - arr2[i] + i;
            max[0] = Math.max(max[0], v0);
            min[0] = Math.min(min[0], v0);
            
            max[1] = Math.max(max[1], v1);
            min[1] = Math.min(min[1], v1);
            
            max[2] = Math.max(max[2], v2);
            min[2] = Math.min(min[2], v2);
            
            max[3] = Math.max(max[3], v3);
            min[3] = Math.min(min[3], v3);
        } 

        for (int k = 0; k < 4; k++) {
            res = Math.max(res, max[k] - min[k]);
        }

        return res;
    }
    
}
class Solution {
    public int numOfSubarrays(int[] arr) {
        int oddCount=0, evenCount = 1, res = 0;
        int sum = 0, MOD = 1_000_000_007;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            if(sum%2==0){
                res+=oddCount;
                evenCount++;
            }else{
                res+=evenCount;
                oddCount++;
            }
            res = res%MOD;
        }
        return res;
    }
}
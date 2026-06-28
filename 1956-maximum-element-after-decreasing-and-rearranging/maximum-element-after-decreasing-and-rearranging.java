class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int ans = 1;
        Arrays.sort(arr);
        for(int i=1;i<arr.length;i++){
            if(arr[i]>=ans+1) ans++;
        }
        return ans;
    }
}
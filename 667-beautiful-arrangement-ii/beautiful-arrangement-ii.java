/*
[1,2,5,3,4]
[1,2,]
*/
class Solution {
    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        int curr = 0;
        for(int i=1;i<n-k;i++){
            ans[curr++] = i;
        }
        for(int i=0;i<=k;i++){
            int bottom = (n-k+i/2);
            int top = n-i/2;
            if(i%2==0){
                ans[curr++]=bottom;
            }else{
                ans[curr++]=top;
            }
        }
        return ans;
    }
}
/*
7 9 8 9 3 2 8

1 2 1 3 2 1 2

*/

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] incrementing = new int[n];
        Arrays.fill(incrementing,1 );
        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1]){
                incrementing[i]+=incrementing[i-1];
            }
        }
        int result = incrementing[n-1];
        int prev = 1;
        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                prev++;
            }else{
                prev = 1;
            }
            result += Math.max(incrementing[i],prev);
        }
        return result;
    }
}
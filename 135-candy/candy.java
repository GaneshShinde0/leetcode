class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] incrementingCandies = new int[n];
        Arrays.fill(incrementingCandies,1);
        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1]){
                incrementingCandies[i]+=incrementingCandies[i-1];
            }
        }
        // System.out.println(Arrays.toString(incrementingCandies));
        int result = incrementingCandies[n-1];
        int prev = 1;
        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                prev++;
            }else{
                prev = 1;
            }
            result+=Math.max(incrementingCandies[i],prev);
        }
        return result;
    }
}
/*
1,0,2
1 1 2
2 1 1


1 2 2 
1 2 1
1 1 1

1,3,2,2,1
1 2 1 1 1
1 2 1 2 1

*/
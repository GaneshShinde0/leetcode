class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int res =0;
        int n = piles.length;
        for(int i=n-2;i>=(piles.length)/3;i-=2){
            res+=piles[i];
        }
        return res;
    }
}
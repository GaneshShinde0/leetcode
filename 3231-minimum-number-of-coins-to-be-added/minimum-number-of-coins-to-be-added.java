// This of this as bit manipulation
class Solution {
    public int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins);
        int currentMax = 0;
        int additions = 0;
        int index = 0;

        while(currentMax<target){
            if(index<coins.length && coins[index]<=currentMax+1){
                currentMax+=coins[index];
                index++;
            }else{
                currentMax+=currentMax+1; 
                additions++;
            }
        }
        return additions;
    }
}
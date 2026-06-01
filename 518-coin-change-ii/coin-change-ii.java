/*
Dry Run 
Input: amount = 5, coins = [1,2,5]
ways = > [1,0,0,0,0,0]
i =1
ways = > [1,1,0,0,0,0]
i=2 => 
ways = > [1,1,2,0,0,0]
i=3
ways = > [1,1,2,3,0,0]
i=4
ways = > [1,1,2,3,5,0]
i=5
ways = > [1,1,2,3,5,9]
*/
class SolutionWillGiveNumberOfPermutations{
    public int change(int amount, int[] coins) {
        int[] ways = new int[amount+1];
        ways[0]=1;
        for(int i=0;i<=amount;i++){
            for(int coin:coins){
                if(i-coin>=0){
                    ways[i]+=ways[i-coin];
                }
            }
        }
        return ways[amount];
    }
}

class Solution{
    public int change(int amount, int[] coins) {
        int[] ways = new int[amount+1];
        ways[0]=1;
        for(int coin:coins){
            for(int i=coin;i<=amount;i++){
                ways[i]+=ways[i-coin];
            }
        }
        return ways[amount];
    }
}
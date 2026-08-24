/*
Both Players know each others values, 
    At every point player will try to take maximum from their pile,
    They will also take the most impactful pile from the piles which might give high score to second player.

Input: aliceValues = [1,3], bobValues = [2,1]
valueSum = [-1,2] // Alice Perspective.
valueSum = [1,-2] // Bob Perspective.

// if we sort value diff, Alice will try to take stones from right, bob will try to take from left.
    - They know how they can take most optimal value for themselves..
    - We will have to add checks to see how can they reduce opponents score
*/
class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length, bobSum=0;
        // Take Value difference from Alices Perspective.
        int[][] valueSum = new int[n][2];
        for(int i=0;i<n;i++){
            valueSum[i][1] = aliceValues[i]+bobValues[i];
            valueSum[i][0] = i; 
            bobSum += bobValues[i];
        }
        Arrays.sort(valueSum, (a,b)-> Integer.compare(b[1],a[1]));
        int aliceScore = 0, bobScore = 0;
        for(int i=0;i<n;i++){
            if(i%2==0)aliceScore += aliceValues[valueSum[i][0]];
            else bobScore += bobValues[valueSum[i][0]];
        }
        if(aliceScore>bobScore) return 1;
        else if(aliceScore<bobScore) return -1;
        return 0;
    }
}
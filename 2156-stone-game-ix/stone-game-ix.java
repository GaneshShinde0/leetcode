class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[] counts = new int[3];
        for (int stone : stones) counts[stone % 3]++;
        return checkWin(1, counts, stones.length) || checkWin(2, counts, stones.length);
    }

    private boolean checkWin(int startStone, int[] originalCounts, int totalStones) {
        if (originalCounts[startStone] == 0) return false; // Alice can't start
        
        int[] count = originalCounts.clone();
        count[startStone]--;
        int sum = startStone;
        int movesMade = 1; // Alice made the 1st move
        
        // 1. Simulate forced 1s and 2s
        while (true) {
            if (sum % 3 == 1 && count[1] > 0) {
                count[1]--;
                sum += 1;
                movesMade++;
            } else if (sum % 3 == 2 && count[2] > 0) {
                count[2]--;
                sum += 2;
                movesMade++;
            } else {
                break; // No forced non-zero moves left
            }
        }
        
        // 2. Add the 0s (they just delay the game)
        movesMade += count[0];
        
        // 3. Did Alice win?
        // She wins if the game didn't end by running out of stones, 
        // AND the last move was made by Bob (meaning Bob is forced to make a losing move).
        // Since movesMade is the total valid moves, think about what movesMade % 2 should be for Alice to win!
        return movesMade%2==1 && movesMade<totalStones;
    }
}
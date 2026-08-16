/*
Intuition:
Lets Treat it like card game, where stones are cards.
1. The Meaning of the "Cards" (Stones)
Instead of looking at the actual numbers, we only care about their remainders when divided by 3 (cnt0, cnt1, cnt2).
- 0s are "Skip Turn" cards: They don’t change the sum at all. Playing a 0 just forces the other person to make a real move.
- 1s and 2s are "Action" cards: Playing these actually changes the sum and drives the game forward.
    - If Alice starts with a 1, the only safe sequence of plays is: 1, 1, 2, 1, 2, 1, 2...
    - If Alice starts with a 2, the only safe sequence of plays is: 2, 2, 1, 2, 1, 2, 1...

2. Case 1: Even number of 0s (cnt0%2==0)
If there is an even number of "Skip Turn" cards, they just cancel each other out, Its as if they dont exit
    - How Alice Wins. She just needs the game to be playable. Since she goes first, cshe can coose winning path, But she must atlease have one of BOTH Types (1s and 2s) to keep the sequence going.
    - If there are onlly 1's she plays 1's; Bob Playes a 1, and she is stuck.
    - Code: return cnt1>=1 && cnt2>=1

3. Case 2: Odd Number of 0's (cnt0%2 !=0)
An odd number of "Skip Turn" cards mean Bob effectively gets one extra "Skip Turn". He will use it to flip a losing game into a winning game for himself.
    - How Alice Wins: Because bob has this advantage, ALices normal strategy fails. She can only win if the game is extremely unbalanced.
    - She needs one type of action card (either 1's or 2's ) to be outnumbered by 2 with other. If one type outnumbers the other by more than 2, Bob runs out of safe moves and loses before the game reaches the end, making his "Skip Turn" card useless.
    - Code return Math.abs(cnt1-cnt2)>2

Summary:
- Even 0's: Alice Just needs at least one of 1 and one 2 to outplay Bob
- Odd 0's: Bob has Skip Turn Advantage, so Alice only wins if the pipe of 1s and 2's is heavily lopsided (difference>2).
*/
class Solution{
    public boolean stoneGameIX(int[] stones){
        int cnt0 = 0, cnt1 = 0, cnt2 = 0;
        for(int val:stones){
            int type = val%3;
            if(type == 0) cnt0++;
            else if(type==1) cnt1++;
            else cnt2++;
        }
        if(cnt0%2==0) return cnt1>=1 && cnt2>=1;
        return cnt1-cnt2>2 || cnt2-cnt1>2;
    }
}
class SolutionInitial {
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
        // movesMade are the safe moves...
            // If there are safe moves at Alices Turn then Alice will win.
                // ALices Turn movesMade%2==1
            // If last safe move was from bob then bob will win
        // Since movesMade is the total valid moves, think about what movesMade % 2 should be for Alice to win!
        return movesMade%2==1 && movesMade<totalStones;
    }
}
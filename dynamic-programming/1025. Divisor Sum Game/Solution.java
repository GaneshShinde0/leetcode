import java.util.HashMap;
import java.util.Map;

public class Solution {

    // Main method to determine if Alice wins given n
    public boolean divisorGame(int n) {
        Map<Integer, Boolean> memo = new HashMap<>();
        return divisorGameMemoized(n, memo);
    }

    // Memoized recursive solution
    // This method uses memoization to store previously computed results
    // Time Complexity: O(n^2)
    // Space Complexity: O(n)
    private boolean divisorGameMemoized(int n, Map<Integer, Boolean> memo) {
        if (n < 2) return false; // Base case: If n < 2, Alice loses
        if (n == 2) return true; // Base case: If n == 2, Alice wins
        if (memo.containsKey(n)) return memo.get(n); // Return cached result if available

        // Try all divisors and see if there is a way for Alice to force Bob into a losing position
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                boolean result = divisorGameMemoized(n - i, memo);
                if (!result) { // If Bob loses with the new value of n, Alice wins
                    memo.put(n, true);
                    return true;
                }
            }
        }

        // If no move leads to Bob's loss, Alice loses
        memo.put(n, false);
        return false;
    }

    // Initial solution with integer-based memoization
    // Returns true if Alice can win by ensuring the number of turns is odd
    public boolean divisorGameInitialSolution(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return divisorGameInitialSolutionHelper(n, memo) % 2 == 1;
    }

    // Recursive method that returns the number of turns
    // Time Complexity: O(n^2)
    // Space Complexity: O(n)
    private int divisorGameInitialSolutionHelper(int n, Map<Integer, Integer> memo) {
        if (n < 2) return 0; // Base case: If n < 2, no valid move, so return 0
        if (n == 2) return 1; // Base case: If n == 2, one move possible, so return 1
        if (memo.containsKey(n)) return memo.get(n); // Return cached result if available

        int moves = 0;
        // Try all divisors and count the number of moves
        for (int i = 1; i <= (n + 1) / 2; i++) {
            if (n % i == 0) {
                moves = divisorGameInitialSolutionHelper(n - i, memo) + 1;
                if (moves % 2 == 1) { // If the number of moves is odd, Alice wins
                    memo.put(n, 1);
                    return 1;
                }
            }
        }

        memo.put(n, moves);
        return moves;
    }

    // Dynamic Programming solution (Alternative Approach)
    // Time Complexity: O(n^2)
    // Space Complexity: O(n)
    public boolean divisorGameDP(int n) {
        boolean[] dp = new boolean[n + 1];
        dp[1] = false; // Base case: n = 1, Alice loses
        dp[2] = true;  // Base case: n = 2, Alice wins

        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0 && !dp[i - j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

    // Mathematical Approach
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    public boolean divisorGameMath(int n) {
        // If n is even, Alice can always win by subtracting 1
        // If n is odd, Bob can always force Alice into a losing position
        return n % 2 == 0;
    }
}

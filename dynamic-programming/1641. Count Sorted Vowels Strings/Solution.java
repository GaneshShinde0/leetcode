class Solution {

    // First method: Combinatorial approach using binomial coefficient
    public int countVowelStringsCombinatorial(int n) {
        // Explanation:
        // The problem can be reduced to counting the number of ways to distribute `n` positions
        // among 5 vowels in a lexicographically sorted manner. This is equivalent to the
        // combinatorial problem of choosing 4 dividers to split n+4 positions into 5 groups.
        // The result is given by the binomial coefficient C(n+4, 4).
        // Which is mathematically equivalent to (n + 4) * (n + 3) * (n + 2) * (n + 1) / 24.
        
        return (n + 4) * (n + 3) * (n + 2) * (n + 1) / 24;
    }

    // Second method: Iterative dynamic programming approach
    public int countVowelStringsIterative(int n) {
        // Explanation:
        // Initialize each vowel to 1, as for n=1, each vowel ('a', 'e', 'i', 'o', 'u') forms a valid string.
        int a = 1, e = 1, i = 1, o = 1, u = 1;

        // For every additional length of string (n-1 times), update the counts for each vowel
        // based on the previous state.
        while (n > 1) {
            // Update 'a' with the sum of all strings that can start with 'a', 'e', 'i', 'o', 'u'.
            a = a + e + i + o + u;

            // Update 'e' with the sum of all strings that can start with 'e', 'i', 'o', 'u'.
            e = e + i + o + u;

            // Update 'i' with the sum of all strings that can start with 'i', 'o', 'u'.
            i = i + o + u;

            // Update 'o' with the sum of all strings that can start with 'o', 'u'.
            o = o + u;

            // 'u' remains the same since it is the last vowel.
            // Decrement n to process the next string length.
            n--;
        }

        // The total number of valid strings of length n is the sum of the counts of strings
        // that can start with any of the vowels 'a', 'e', 'i', 'o', 'u'.
        return a + e + i + o + u;
    }
}

class Solution {
    public int getPermutationIndex(int[] perm) {
        int n = perm.length; // Store the length of the permutation array
        long[] fact = new long[n + 1]; // Create an array to store factorials
        fact[0] = 1; // Set the first element of the factorial array to 1
        for (int i = 1; i <= n; i++) { // Iterate over the elements of the factorial array
            fact[i] = (fact[i - 1] * i) % MOD; // Calculate and store factorial values modulo MOD
        }

        // Rank elements
        int[] ranked = Arrays.copyOf(perm, n); // Copy the permutation array
        Arrays.sort(ranked); // Sort the copied array
        Map<Integer, Integer> rankMap = new HashMap<>(); // Create a map to store element ranks
        for (int i = 0; i < n; i++) { // Iterate over the elements of the sorted array
            rankMap.put(ranked[i], i + 1); // Map each element to its rank
        }

        // Initialize Fenwick Tree
        FenwickTree fenwickTree = new FenwickTree(n); // Create a FenwickTree object with size n

        long index = 0; // Initialize the index counter
        for (int i = n - 1; i >= 0; i--) { // Iterate over the permutation array in reverse order
            int rank = rankMap.get(perm[i]); // Get the rank of the current element
            // Query the number of elements smaller than the current one
            index += fenwickTree.query(rank - 1) * fact[n - 1 - i] % MOD; // Update the index using Fenwick Tree query result and factorial value
            index %= MOD; // Update the index modulo MOD
            // Update the count of the current element
            fenwickTree.update(rank, 1); // Update Fenwick Tree with count of the current element
        }

        return (int) index; // Return the index
    }

    private static final int MOD = 1000000007; // Define the modulo constant

    private static class FenwickTree { // Define a FenwickTree class
        private final int[] tree; // Declare an array to store Fenwick Tree nodes
        private final int n; // Declare a variable to store size of Fenwick Tree

        public FenwickTree(int size) { // Constructor to initialize Fenwick Tree
            this.n = size; // Set the size of Fenwick Tree
            this.tree = new int[n + 1]; // Initialize the Fenwick Tree array
        }

        public void update(int i, int delta) { // Method to update Fenwick Tree node
            while (i <= n) { // Iterate over the Fenwick Tree
                tree[i] += delta; // Update the Fenwick Tree node
                i += i & -i; // Move to the next node
            }
        }

        public int query(int i) { // Method to query Fenwick Tree
            int sum = 0; // Initialize sum variable
            while (i > 0) { // Iterate over the Fenwick Tree
                sum += tree[i]; // Update the sum with the Fenwick Tree node value
                i -= i & -i; // Move to the parent node
            }
            return sum; // Return the sum
        }
    }
}
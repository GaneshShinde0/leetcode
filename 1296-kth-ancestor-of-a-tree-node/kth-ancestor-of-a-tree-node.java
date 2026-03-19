/*
Given Tree of size N, rooted at 0,

Answer Q queries.
    Given v and k, find kth ancestor of v.

Repeat k times
    v = parent[v]
O(Q*N)-> O(...+Q*log(N))

How do we improve from O(N) to O(log(N))
    - Divide By Two
        - Binary Search
        - Divide and Conqueor
    - Power Of Two
        - Segment Trees
        - Binary Lifting
        - Sparse Tables

# Binary Lifting: Also called Jump Pointers
- Here any K can be represented as sum of powers of 2 (or binary number)
- E.G. k = 19 = 16+2+1=> 3 Jumps

-- How can we jump by 2^n steps.
-- We already know how to up by one step, as thats parent of vertex.(Given as input)
    -- GrandParent parent[parent[v]]

int up[N][LOG]
up[v][j] -- 2^j th ancestor of V
for(v=0....N-1)
    up[v][0] = parent[v]
    up[v][1] = up[up[v][0]][0]
    up[v][2] = up[up[v][1]][1]
    up[v][3] = up[up[v][1]][1]
    ....


int up[N][LOG]
up[v][j] -- 2^j th ancestor of V
for(v=0....N-1)
    up[v][0] = parent[v]
    for(j==1 .... log 1)
    up[v][j] = up[up[v][j-1]][j-1]

Time & Space Complexity: (Assuming parent[i]<i)
    O(N*log(N)) -> log(n) depth of tree..


*/ 

class TreeAncestor {
    int[][] up;
    int[] depth;
    int log;

    public TreeAncestor(int n, int[] parent) {
        this.log = 0;
        while((1 << log) <= n) {
            log++;
        }
        this.up = new int[n][log];
        // Removed unused depth array
        // Removed parent[0] = 0; -> We WANT parent[0] to be -1
        
        // 3. Fill the first column (2^0 = 1st ancestor)
        for (int v = 0; v < n; v++) {
            up[v][0] = parent[v];
        }

        // 4. Fill remaining columns: Loop j (levels) first, then v (nodes)
        for (int j = 1; j < log; j++) {
            for (int v = 0; v < n; v++) {
                if (up[v][j-1] != -1) {
                    up[v][j] = up[up[v][j-1]][j-1];
                } else {
                    up[v][j] = -1;
                }
            }
        }
    }
    
   public int getKthAncestor(int node, int k) {
        // Iterate bits of k
        for (int j = 0; j < log; j++) {
            if ((k & (1 << j)) != 0) {
                node = up[node][j];
                // If we hit -1, no need to continue
                if (node == -1) return -1;
            }
        }
        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */
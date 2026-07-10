import java.util.Arrays;

class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        // Sort indices based on their corresponding values in nums
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;
        Arrays.sort(idx, (a, b) -> Integer.compare(nums[a], nums[b]));
        
        // Map original index to sorted position
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) pos[idx[i]] = i;
        
        int LOG = 18; // 2^17 > 10^5 (max possible nodes), covers any path length
        int[][] up = new int[n][LOG];
        
        // Build base jumps directly into up[i][0]
        for (int l = 0, r = 0; l < n; l++) {
            while (r + 1 < n && nums[idx[r + 1]] - nums[idx[l]] <= maxDiff) r++;
            up[l][0] = r;
        }
        
        // Build the rest of the binary lifting table
        for (int j = 1; j < LOG; j++) {
            for (int i = 0; i < n; i++) {
                up[i][j] = up[up[i][j - 1]][j - 1]; 
            }
        }
        
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = pos[queries[i][0]], v = pos[queries[i][1]];
            if (u > v) { int t = u; u = v; v = t; } // Swap to ensure u <= v
            
            // If massive jumps can't reach v, they are disconnected
            if (up[u][LOG - 1] < v) {
                res[i] = -1;
            } else if (u == v) {
                res[i] = 0;
            } else {
                int hops = 0;
                for (int j = LOG - 1; j >= 0; j--) {
                    if (up[u][j] < v) {
                        u = up[u][j];
                        hops += (1 << j);
                    }
                }
                res[i] = hops + 1;
            }
        }
        return res;
    }
}
class UnionFind {
    int n;
    int[] parent;
    int[] rank;
    UnionFind(int n){
        this.n = n;
        this.parent = new int[n];
        this.rank = new int[n];
        for(int i = 0; i < n; i++){
            this.parent[i] = i;
        }
    }
    public int find(int x){
        if(parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
    public void union(int x, int y){
        int xPar = find(x), yPar = find(y);
        if(xPar == yPar) return;
        else if(rank[xPar] > rank[yPar]){
            parent[yPar] = xPar;
        }else if(rank[yPar] > rank[xPar]){
            parent[xPar] = yPar;
        }else{
            parent[yPar] = xPar;
            rank[xPar]++;
        }
    }
}

class SolutionTLE {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[][] idxAndNum = new int[n][2];
        for(int i = 0; i < n; i++){
            idxAndNum[i][0] = i;
            idxAndNum[i][1] = nums[i];
        }
        
        Arrays.sort(idxAndNum, (a, b) -> Integer.compare(a[1], b[1]));
        
        // Map to quickly find the sorted index of an original node
        int[] origToSorted = new int[n];
        for(int i = 0; i < n; i++){
            origToSorted[idxAndNum[i][0]] = i;
        }

        UnionFind uf = new UnionFind(n);
        int[] jump = new int[n];
        int right = 0;

        for (int left = 0; left < n; left++) {
            // Union adjacent elements if they are within maxDiff
            if (left + 1 < n && idxAndNum[left + 1][1] - idxAndNum[left][1] <= maxDiff) {
                uf.union(idxAndNum[left][0], idxAndNum[left + 1][0]);
            }
            
            // Keep moving right as long as the difference is within maxDiff
            while (right + 1 < n && idxAndNum[right + 1][1] - idxAndNum[left][1] <= maxDiff) {
                right++;
            }
            jump[left] = right; 
        }
        
        int[] res = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int[] query = queries[i];
            int u = query[0], v = query[1];
            
            if (uf.find(u) != uf.find(v)) {
                res[i] = -1;
            } else {
                int sortedU = origToSorted[u];
                int sortedV = origToSorted[v];
                
                // Ensure we always jump from left to right
                if (sortedU > sortedV) {
                    int temp = sortedU;
                    sortedU = sortedV;
                    sortedV = temp;
                }
                
                int hops = 0;
                int curr = sortedU;
                
                // Naively jump until we reach or pass the target
                while (curr < sortedV) {
                    curr = jump[curr];
                    hops++;
                }
                res[i] = hops;
            }
        }
        return res;
    }
}

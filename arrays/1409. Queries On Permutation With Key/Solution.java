class Solution {
    // Naive Solution which took around 30 min to develop; 3 ms to run (beats 93%)
    public int[] processQueriesNaive(int[] queries, int m) {
        int[] p = new int[m];
        int[] res = new int[queries.length];
        for(int i=1;i<=m;i++){
            p[i-1]=i;
        }
        for(int i=0;i<queries.length;i++){
            // int j = queries[i]; Instead of using extra j, lets directly pass queries[i] to getQueryPointer
            int queryPointer = getQueryPointer(p,queries[i]);
            int temp=p[queryPointer];
            res[i]=queryPointer;
            for(int k=queryPointer-1;k>=0;k--){
                p[k+1]=p[k];
            }
            p[0]=temp;
        }
        return res;
    }

    public int getQueryPointer(int[] p, int k){
        for(int i=0;i<p.length;i++){
            if(p[i]==k) return i;
        }
        return -1;
    }

    // Following is more readable but takes about 24 ms (Beats 5.81%)
    public int[] processQueries(int[] queries, int m) {
        List<Integer> p = new ArrayList<>();
        Map<Integer, Integer> indexMap = new HashMap<>();
        int[] res = new int[queries.length];
        
        // Initialize p and indexMap
        for (int i = 1; i <= m; i++) {
            p.add(i);
            indexMap.put(i, i - 1); // element -> current index in the list
        }

        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            int queryPointer = indexMap.get(query); // O(1) lookup
            res[i] = queryPointer;

            // Move the queried number to the front
            p.remove(queryPointer);       // O(m) in worst case, but rare due to move-to-front strategy
            p.add(0, query);              // O(1) as we insert at the beginning
            
            // Update the indices in the indexMap
            for (int j = 0; j <= queryPointer; j++) {
                indexMap.put(p.get(j), j); // Update only affected elements
            }
        }

        return res;
    }
}

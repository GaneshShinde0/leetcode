class Solution {
    private int MOD = 1_000_000_007;
    class Pair{
        int key;
        long val;
        public Pair(int key, long val){
            this.key = key;
            this.val = val;
        }
    }
    public int[] queryConversions(int[][] conversions, int[][] queries) {
        Map<Integer, List<Pair>> graph = new HashMap<>();
        for(int[] conv: conversions){
            int u = conv[0], v = conv[1], d = conv[2];
            graph.computeIfAbsent(u,x->new ArrayList<Pair>()).add(new Pair(v,d));
            long inverseFactor = pow(d,MOD-2); // Fermat's Little Theorem.....
            graph.computeIfAbsent(v,x->new ArrayList<Pair>()).add(new Pair(u,inverseFactor));
        }
        // Conversion Factor related to 0
        long[] relativeToZero = new long[conversions.length+1];
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0,1l));
        long conv = 1l;
        while(!queue.isEmpty()){
            Pair curr = queue.poll();
            relativeToZero[curr.key] = curr.val;
            for(Pair p: graph.get(curr.key)){
                if(relativeToZero[p.key]!=0) continue;
                conv = (p.val*curr.val)%MOD;
                queue.add(new Pair(p.key, (p.val*curr.val)%MOD));
            }
        }
        int[] res = new int[queries.length];
        for(int i = 0;i<queries.length;i++){
            int[] query = queries[i];
            int u = query[0], v = query[1];
            // Relative to Zero is 0-> u... 
            // Now we have to find u->0 and 0 to v
            long inverseFactor = pow(relativeToZero[u],MOD-2);
            res[i] = (int) ((relativeToZero[v]*inverseFactor)%MOD);
        }
        return res;
    }

    private long pow(long x, long y){
        long res = 1;
        while(y>0){
            if((y&1)==1) res = res*x %MOD;
            x = x*x%MOD;
            y>>=1;
        }
        return res;
    }
}
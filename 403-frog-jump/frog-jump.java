class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;
        if (stones[1] != 1) return false;

        // Optimization 1: Use primitive byte array instead of Boolean wrapper
        // 0 = unknown, 1 = true, 2 = false
        byte[][] memo = new byte[n][n + 1];

        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hm.put(stones[i], i);
        }
        
        return jumps(1, 1, stones, hm, memo);
    }

    public boolean jumps(int index, int k, int[] stones, HashMap<Integer, Integer> hm, byte[][] memo) {
        if (index == stones.length - 1) return true;
        
        // Check cache (0 means not calculated yet)
        if (memo[index][k] != 0) {
            return memo[index][k] == 1;
        }

        // Optimization 2: Eliminate 'new int[]' allocation with a loop
        for (int nextK = k - 1; nextK <= k + 1; nextK++) {
            if (nextK > 0) {
                int nextStoneVal = stones[index] + nextK;
                
                // Optimization 3: Single map lookup instead of containsKey + get
                Integer nextIndex = hm.get(nextStoneVal); 
                
                if (nextIndex != null && jumps(nextIndex, nextK, stones, hm, memo)) {
                    memo[index][k] = 1; // Mark as True
                    return true;
                }
            }
        }
        
        memo[index][k] = 2; // Mark as False
        return false;
    }

    public boolean canCrossInitial(int[] stones) {
        int n = stones.length;
        if(stones[1]!=1) return false;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            hm.put(stones[i], i);
        }
        Boolean[][] cache = new Boolean[n][n+1];
        return jumps(1,1,stones,hm,cache);
    }

    public boolean jumps(int index, int k, int[] stones, HashMap<Integer, Integer> hm,Boolean[][] cache){
        if(index == stones.length-1) return true;
        if(cache[index][k]!=null) return cache[index][k];
        int current = stones[index];
        int[] nk = {k-1,k,k+1};
        for(int i:nk){
            int jump = current+i;
            if(i>0 && hm.containsKey(jump) && jumps(hm.get(jump), i, stones, hm,cache)) {
                cache[index][k]=true;
                return true; 
            }
        }
        cache[index][k]=false;
        return false;
    }
}
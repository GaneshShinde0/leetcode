class Solution {
    public boolean canCross(int[] stones) {
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
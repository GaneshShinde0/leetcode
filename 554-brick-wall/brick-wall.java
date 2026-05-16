class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Long,Integer> hm = new HashMap<>();
        int layers = wall.size();
        long maxAligned = 0;
        long width = 0;
        for(int i:wall.get(0)) width+=i;
        for(List<Integer> w:wall){
            long currEnd = 0;
            for(int e:w){
                currEnd+=e;
                hm.put(currEnd,hm.getOrDefault(currEnd,0)+1);
                if(currEnd!=width) maxAligned = Math.max(hm.get(currEnd),maxAligned);
            }
        }
        return (int)(layers-maxAligned);
    }
}
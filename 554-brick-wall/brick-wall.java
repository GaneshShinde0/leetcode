class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Long, Long> hm = new HashMap<>();
        long width = 0, maxCuts = 0;
        for(int curr: wall.get(0)) width+=curr;
        long temp = 0;
        for(int i=0;i<wall.size();i++){
            long curr = 0;
            for(int j:wall.get(i)){
                curr+=j;
                if(curr!=width) hm.put(curr, hm.getOrDefault(curr,0l)+1);
                temp = Math.max(temp, hm.getOrDefault(curr,0l));
            }
        }
        return (int) (wall.size()-temp);
    }
}
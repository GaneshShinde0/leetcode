class Solution {
    public int shareCandies(int[] candies, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = candies.length, res=0;
        for(int c:candies){
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        for(int i=0;i<n;i++){
            if(i-k>=0){
                res = Math.max(res,hm.size());
                hm.put(candies[i-k],hm.getOrDefault(candies[i-k],0)+1);
            }
            int c = candies[i];
            hm.put(c,hm.getOrDefault(c,0)-1);
            if(hm.get(c)==0) hm.remove(c);
        }
        return Math.max(res,hm.size());
    }
}
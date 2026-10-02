class Solution {
    public int maximumBeauty(int[] flowers) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int res = Integer.MIN_VALUE;
        for(int f : flowers) {
            if(map.containsKey(f)) {
                res = Math.max(res, sum - map.get(f) + 2 * f); //+ 2*f to include both ends
            }
            if(f > 0) {
                sum += f; 
            }
            if(!map.containsKey(f)) {
                map.put(f, sum);
            }
        }
        return res;
    }
}
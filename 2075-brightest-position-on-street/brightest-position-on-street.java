class Solution {
    public int brightestPosition(int[][] lights) {
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for(int[] light:lights){
            low = Math.min(low, light[0]-light[1]);
            low = Math.min(low, light[0]+light[1]);
        }
        int offSet = low;
        TreeMap<Integer,Integer> hm = new TreeMap<>();
        for(int[] light:lights){
            int start = light[0]-light[1]-offSet;
            int end = light[0]+light[1]-offSet+1;
            hm.put(start, hm.getOrDefault(start,0)+1);
            hm.put(end, hm.getOrDefault(end,0)-1);
        }

        int res = offSet, curr = 0, max=0;

        for(Map.Entry<Integer,Integer> e:hm.entrySet()){
            curr+=e.getValue();
            if(curr>max){
                max = curr;
                res = e.getKey();
            }
        }
        return res+offSet;
    }
}
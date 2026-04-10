class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        HashMap<Integer,List<Integer>> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            hm.computeIfAbsent(nums[i],k->new ArrayList<>()).add(i);
        }
        for(Map.Entry<Integer,List<Integer>> e: hm.entrySet()){
            List<Integer> idx = e.getValue();
            int size = idx.size();
            if(idx.size()<3) continue;
            for(int i=2;i<size;i++){
            int localMax = 2*idx.get(i)-2*idx.get(i-2);
            res = Math.min(localMax,res);
            }
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
}
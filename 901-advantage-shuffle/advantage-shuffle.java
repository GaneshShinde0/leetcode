class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        TreeMap<Integer,Integer> tm = new TreeMap<>();
        for(int num:nums1){
            tm.put(num, tm.getOrDefault(num,0)+1);
        }
        int[] res = new int[n];
        Arrays.fill(res,-1);
        for(int i=0;i<n;i++){
            Map.Entry<Integer,Integer> e = tm.higherEntry(nums2[i]);
            if(e!=null){
                res[i] = e.getKey();
                if(e.getValue()>1) tm.put(res[i],e.getValue()-1);
                else tm.remove(e.getKey());
            }
        }
        for(int i=0;i<n;i++){
            if(res[i]==-1){
                Map.Entry<Integer,Integer> e = tm.firstEntry();
                res[i] = e.getKey();
                if(e.getValue()>1) tm.put(res[i],e.getValue()-1);
                else tm.remove(e.getKey());
            }
        }
        return res;
    }
}
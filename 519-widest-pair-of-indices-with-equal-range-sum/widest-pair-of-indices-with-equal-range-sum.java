class Solution {
    public int widestPairOfIndices(int[] nums1, int[] nums2) {
        int n = nums1.length, res = 0, sum1=0, sum2=0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0,-1);
        for(int i=0;i<n;i++){
            sum1+=nums1[i];
            sum2+=nums2[i];
            int diff = sum1-sum2;
            if(hm.containsKey(diff)){
                res = Math.max(res, (i)-hm.get(diff));
            }else{
                hm.put(diff,i);
            }
        }
        return res;
    }
}
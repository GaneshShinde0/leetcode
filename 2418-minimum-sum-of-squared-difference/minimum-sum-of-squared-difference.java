class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length, k = k1+k2;
        TreeMap<Long, Long> tm = new TreeMap<>();
        for(int i=0;i<n;i++){
            long x = Math.abs(nums1[i]-nums2[i]);
            tm.put(x, tm.getOrDefault(x,0l)+1);
        }
        long res = 0;
        while(tm.size()>0 && k>0){
            Map.Entry<Long, Long> e = tm.lastEntry();
            int remove = (int) Math.min(e.getValue(), k);
            tm.put(e.getKey(), e.getValue()-remove);
            k-=remove;
            if(e.getKey() == 0){
                tm.remove(e.getKey());
                continue;
            }
            if(e.getValue()==0){
                tm.remove(e.getKey());
            }
            long newVal = e.getKey()-1;
            tm.put(newVal, tm.getOrDefault(newVal,0L)+remove);
        }
        for(Map.Entry<Long, Long> e: tm.entrySet()){
            res+= 1l*e.getKey()*e.getKey()*e.getValue();
        }
        return res;
    }
    public long minSumSquareDiff1(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length, k = k1+k2, max = 0;
        int[] num = new int[n];
        int[] diffs = new int[100001];
        long res = 0, sum = 0;
        for(int i=0;i<n;i++){
            int x = Math.abs(nums1[i]-nums2[i]);
            sum+=x;
            diffs[x]++;
            max = Math.max(max, x);
        }
        if(sum<=k) return 0;
        for(int i = max;i>0;i--){
            int move = Math.min(k, diffs[i]);
            diffs[i] -= move;
            diffs[i-1] += move;
            k-=move;
            res += 1l*i*i*diffs[i];
        }
        return res;
    }
}
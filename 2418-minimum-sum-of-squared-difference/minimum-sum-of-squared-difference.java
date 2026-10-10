class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k = (long) k1 + k2; // Use long to avoid overflow if k is large
        
        TreeMap<Long, Long> tm = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            long diff = Math.abs(nums1[i] - nums2[i]);
            tm.put(diff, tm.getOrDefault(diff, 0L) + 1);
        }

        while (k > 0 && !tm.isEmpty()) {
            Map.Entry<Long, Long> e = tm.lastEntry();
            long val = e.getKey();
            long count = e.getValue();
            // If the largest difference is 0, we can't reduce further
            if (val == 0) break;
            // How many operations we can apply to this group
            long remove = Math.min(count, k);
            // Update k
            k -= remove;
            // Remove from the current 'val' bucket
            if (count == remove) {
                tm.remove(val); // All instances reduced, remove key
            } else {
                tm.put(val, count - remove); // Some remain
            }
            // Add the reduced instances to 'val - 1' bucket
            long newVal = val - 1;
            tm.put(newVal, tm.getOrDefault(newVal, 0L) + remove);
        }

        // Calculate final result
        long res = 0;
        for (Map.Entry<Long, Long> entry : tm.entrySet()) {
            long diff = entry.getKey();
            long count = entry.getValue();
            res += diff * diff * count;
        }

        return res;
    }
    public long minSumSquareDiffInitial(int[] nums1, int[] nums2, int k1, int k2) {
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
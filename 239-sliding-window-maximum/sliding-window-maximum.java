class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];
        Arrays.fill(res,Integer.MIN_VALUE);
        // if(k==1) return nums;
        TreeMap<Integer,Integer> tm = new TreeMap<>();
        for(int i=0;i<n;i++){
            tm.put(nums[i], tm.getOrDefault(nums[i],0)+1);
            if(i-k>=0){
                tm.put(nums[i-k],tm.getOrDefault(nums[i-k],0)-1);
                if(tm.get(nums[i-k])<=0) tm.remove(nums[i-k]);
            }
            res[Math.max(i-k+1,0)] = Math.max(res[Math.max(i-k+1,0)],tm.lastEntry().getKey());
            
        }
        return res;
    }
    // public int[] maxSlidingWindow(int[] nums, int k) {
    //     int n = nums.length;
    //     int[] res = new int[n-k+1];
    //     Arrays.fill(res,Integer.MIN_VALUE);
    //     // if(k==1) return nums;
    //     PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(b[1],a[1]));
    //     for(int i=0;i<n;i++){
    //         pq.add(nums[i]);
    //         if(i-k>=0){
    //             pq.poll();
    //         }
    //         res[Math.max(i-k+1,0)] = Math.max(res[Math.max(i-k+1,0)],pq.peek());
            
    //     }
    //     return res;
    // }
}
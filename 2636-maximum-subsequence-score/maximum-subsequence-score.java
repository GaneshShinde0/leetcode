class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] nums1AndNums2 = new int[n][2];
        for(int i=0;i<n;i++){
            nums1AndNums2[i] = new int[]{nums1[i],nums2[i]};
        }
        Arrays.sort(nums1AndNums2,(a,b)->b[1]-a[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(k,(a,b)->Integer.compare(a,b));
        long res = 0, sum = 0;
        for(int[] curr:nums1AndNums2){
            pq.add(curr[0]);
            sum +=curr[0];
            if(pq.size()>k) sum -= pq.poll();
            if(pq.size()==k) res = Math.max(res,sum*curr[1]);
        }
        return res;
    }
}
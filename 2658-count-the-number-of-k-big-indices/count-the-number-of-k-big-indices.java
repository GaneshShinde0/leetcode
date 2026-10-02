class Solution {
    public int kBigIndices(int[] nums, int k) {
        int n = nums.length; 
        boolean[] prefix = new boolean[n]; 
        Queue<Integer> pq = new PriorityQueue(Collections.reverseOrder()); 
        for (int i = 0; i < n; ++i) {
            if (pq.size() == k && pq.peek() < nums[i]) prefix[i] = true; 
            pq.add(nums[i]); 
            if (pq.size() > k) pq.poll(); 
        }
        int ans = 0; 
        pq.clear(); 
        for (int i = n-1; i >= 0; --i) {
            if (pq.size() == k && pq.peek() < nums[i] && prefix[i]) ++ans; 
            pq.add(nums[i]); 
            if (pq.size() > k) pq.poll(); 
        }
        return ans; 
    }
}
class Solution {
    // Havel-Hakimi Algorithm
    // "If a valid graph exists, the vertex with the highest degree must be able to connect to the next highest-degree vertices."
    public boolean simpleGraphExistsHavelHakimiAlgorithm(int[] degrees) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int d:degrees) pq.add(d);
        while(!pq.isEmpty()){
            int p1 = pq.poll();
            if(pq.size()<p1) return false;
            List<Integer> li = new ArrayList<>();
            for(int i=0;i<p1;i++){
                if(pq.peek()==0) return false;
                li.add(pq.poll()-1);
            }
            pq.addAll(li);
        }
        return true;
    }

// Erdos Gallai Theorem
/*
SImulating edges is too slow, we can use math theorem that validates the sequence  in O(NLogN) time.

First sort the array in descending order.
For Every k from 1 to N Following condition must hold true.

sum(d[i] from 1 to k) <= k * (k - 1) + sum(min(d[i], k) from k + 1 to n)
(As array is 0-indexed, this translates to checking sum(d[0]...d[k-1]) <= k * (k - 1) + sum(min(d[i], k) for i = k...n-1)).


*/
    public boolean simpleGraphExists(int[] degrees) {
        int n = degrees.length;
        long sum = 0;
        
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            sum += degrees[i];
            arr[i] = degrees[i];
        }
        
        // 1. Parity Check
        if (sum % 2 != 0) return false;
        
        // Sort descending
        Arrays.sort(arr, Collections.reverseOrder());
        
        // 2. Standard Prefix Sum (No Math.min here!)
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }
        
        long sumOfDegrees = 0;
        
        // 3. Main Theorem Check
        for (int i = 0; i < n; i++) {
            sumOfDegrees += arr[i];
            long k = i + 1;
            
            // We need to find the boundary where the elements drop below 'k'.
            // Since the array is descending, we search in range [k, n-1] for the first element < k.
            int left = (int)k;
            int right = n - 1;
            int idx = n; // Default: if no element is < k, the boundary is n
            
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (arr[mid] < k) {
                    idx = mid;
                    right = mid - 1; // Look for earlier drops
                } else {
                    left = mid + 1;
                }
            }
            
            // Now calculate rightSum exactly as the theorem states
            long countOfElementsGreaterOrEqualToK = idx - k;
            long sumOfElementsLessThanK = prefixSum[n] - prefixSum[idx];
            
            long rightSum = k * (k - 1) + (countOfElementsGreaterOrEqualToK * k) + sumOfElementsLessThanK;
            
            if (sumOfDegrees > rightSum) {
                return false;
            }
        }
        return true;
    }
}
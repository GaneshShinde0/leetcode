class Solution {
    public long modeWeight(int[] nums, int k) {
        long result = 0;
        HashMap<Integer,Integer> numToFreq = new HashMap<>();
        TreeMap<Integer,TreeSet<Integer>> freqToNum = new TreeMap<>();
        
        for(int i=0; i<nums.length; i++){
            int freq = numToFreq.getOrDefault(nums[i], 0);
            numToFreq.put(nums[i], freq + 1);
            
            // Optimization 1: Only remove if freq > 0. 
            // Prevents creating useless key '0' in freqToNum.
            if (freq > 0) { 
                freqToNum.computeIfAbsent(freq, t -> new TreeSet<Integer>()).remove(nums[i]);
                // Optimization: Clean up empty sets immediately to keep map small
                if (freqToNum.get(freq).isEmpty()) {
                    freqToNum.remove(freq);
                }
            }
            
            freqToNum.computeIfAbsent(freq + 1, t -> new TreeSet<Integer>()).add(nums[i]);

            if(i >= k - 1){
                // Optimization 2: Call lastEntry() once
                var entry = freqToNum.lastEntry();
                result += 1L * entry.getKey() * entry.getValue().first();
                
                // Sliding window removal
                int numToRemove = nums[i - k + 1];
                freq = numToFreq.get(numToRemove);
                
                freqToNum.computeIfAbsent(freq, t -> new TreeSet<Integer>()).remove(numToRemove);
                if(freqToNum.get(freq).isEmpty()) freqToNum.remove(freq);
                
                freq = freq - 1;
                
                // Optimization 3: Handle freq updates efficiently
                if (freq == 0) {
                    numToFreq.remove(numToRemove);
                    // Do NOT add to freqToNum at key 0. It is useless work.
                } else {
                    numToFreq.put(numToRemove, freq);
                    freqToNum.computeIfAbsent(freq, t -> new TreeSet<Integer>()).add(numToRemove);
                }
            }
        }
        return result;
    }
}
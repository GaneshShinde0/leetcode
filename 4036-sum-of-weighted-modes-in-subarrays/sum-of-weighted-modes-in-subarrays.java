class Solution {
    public long modeWeight(int[] nums, int k) {
        long result = 0;
        // Optimization: Use HashMap instead of TreeMap. 
        // We will track maxFreq manually for O(1) access.
        Map<Integer, Integer> numToFreq = new HashMap<>();
        Map<Integer, TreeSet<Integer>> freqToNum = new HashMap<>();
        
        int maxFreq = 0;

        for (int i = 0; i < nums.length; i++) {
            // --- 1. Add current number (nums[i]) ---
            int num = nums[i];
            int oldFreq = numToFreq.getOrDefault(num, 0);
            int newFreq = oldFreq + 1;
            
            numToFreq.put(num, newFreq);
            
            // Remove from old freq bucket
            if (oldFreq > 0) {
                removeFromFreqMap(freqToNum, oldFreq, num);
            }
            
            // Add to new freq bucket
            freqToNum.computeIfAbsent(newFreq, t -> new TreeSet<>()).add(num);
            
            // Update Max Freq (Bottleneck Optimization)
            maxFreq = Math.max(maxFreq, newFreq);

            // --- 2. Remove old number (slide window) ---
            if (i >= k) { // Note: standard sliding window usually processes remove first or after result calculation
                int oldNum = nums[i - k];
                int prevFreqOfOldNum = numToFreq.get(oldNum);
                int newFreqOfOldNum = prevFreqOfOldNum - 1;
                
                // Remove from current bucket
                removeFromFreqMap(freqToNum, prevFreqOfOldNum, oldNum);
                
                // If this bucket was the maxFreq and is now empty, decrease maxFreq
                if (prevFreqOfOldNum == maxFreq && !freqToNum.containsKey(maxFreq)) {
                    maxFreq--;
                }
                
                // Add to lower freq bucket
                if (newFreqOfOldNum > 0) {
                    numToFreq.put(oldNum, newFreqOfOldNum);
                    freqToNum.computeIfAbsent(newFreqOfOldNum, t -> new TreeSet<>()).add(oldNum);
                } else {
                    numToFreq.remove(oldNum);
                }
            }

            // --- 3. Calculate Result ---
            if (i >= k - 1) {
                // O(1) access to the max frequency bucket
                long mode = freqToNum.get(maxFreq).first(); 
                result += (long) maxFreq * mode;
            }
        }
        return result;
    }

    // Helper to reduce code duplication (D in BUD)
    private void removeFromFreqMap(Map<Integer, TreeSet<Integer>> map, int freq, int num) {
        if (!map.containsKey(freq)) return;
        TreeSet<Integer> set = map.get(freq);
        set.remove(num);
        if (set.isEmpty()) {
            map.remove(freq);
        }
    }

    public long modeWeightInitial(int[] nums, int k) {
        long result = 0;
        HashMap<Integer,Integer> numToFreq = new HashMap<>();
        TreeMap<Integer,TreeSet<Integer>> freqToNum = new TreeMap<>();
        for(int i=0;i<nums.length;i++){
            int freq = numToFreq.getOrDefault(nums[i],0);
            numToFreq.put(nums[i],freq+1);
            freqToNum.computeIfAbsent(freq,t->new TreeSet<Integer>()).remove(nums[i]);
            freqToNum.computeIfAbsent(freq+1,t->new TreeSet<Integer>()).add(nums[i]);
            if(i>=k-1){
                result += 1l*freqToNum.lastEntry().getKey()*freqToNum.lastEntry().getValue().first();
                freq = numToFreq.get(nums[i-k+1]);
                freqToNum.computeIfAbsent(freq,t->new TreeSet<Integer>()).remove(nums[i-k+1]);
                if(freqToNum.get(freq).size()==0) freqToNum.remove(freq);
                freq = freq-1;
                numToFreq.put(nums[i-k+1],freq);
                freqToNum.computeIfAbsent(freq,t->new TreeSet<Integer>()).add(nums[i-k+1]);
                if(numToFreq.get(nums[i-k+1])==0) numToFreq.remove(nums[i-k+1]);
            }
        }
        return result;
    }

}
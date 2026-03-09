class Solution {
    public long modeWeight(int[] nums, int k) {
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
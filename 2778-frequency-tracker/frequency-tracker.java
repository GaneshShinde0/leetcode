class FrequencyTracker {

    int[] freq;
    HashMap<Integer,Integer> hasFreqMap = new HashMap<>();
    public FrequencyTracker() {
        this.freq = new int[100001];
    }
    
    public void add(int number) {
        int temp = freq[number];
        freq[number]++;
        hasFreqMap.put(temp+1,hasFreqMap.getOrDefault(temp+1,0)+1);
        hasFreqMap.put(temp,hasFreqMap.getOrDefault(temp,1)-1);
    }
    
    public void deleteOne(int number) {
        int temp = freq[number];
        freq[number] = Math.max(0,--freq[number]);
        if(temp>0){
            hasFreqMap.put(temp, hasFreqMap.getOrDefault(temp,1)-1);
            hasFreqMap.put(temp-1, hasFreqMap.getOrDefault(temp-1,0)+1);

        }
    }
    
    public boolean hasFrequency(int frequency) {
        return (hasFreqMap.containsKey(frequency) && hasFreqMap.get(frequency)>0);
    }
}

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */
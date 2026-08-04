class Solution {
    public boolean partitionArray(int[] nums, int k) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        int maxFreq = 0;
        for(int i:nums){
            freq.put(i, freq.getOrDefault(i,0)+1);
            maxFreq = Math.max(freq.get(i), maxFreq);
        }
        return (1l*maxFreq*k<=nums.length && nums.length%k==0 );
    }
}
class Solution {
    public int findSmallestIntegerTLE(int[] nums, int k) {
        // HashMap<Integer,Integer> hm = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int i:nums){
            int curr = (i%k+k)%k;
            while(set.contains(curr)){
                curr +=k;
            }
            set.add(curr);
        }
        for(int i=0;i<=nums.length;i++){
            if(!set.contains(i)) return i;
        }
        return 0;
    }

    public int findSmallestInteger(int[] nums, int k) {
        // HashMap<Integer,Integer> hm = new HashMap<>();
        int[] freq = new int[k];
        for(int i:nums){
            int curr = (i%k+k)%k;
            freq[curr]++;
        }
        int minFreq=0;
        for(int i=0;i<k;i++){
            if(freq[i]<freq[minFreq]) minFreq =i; 
        }
        return freq[minFreq]*k+minFreq;
    }
}
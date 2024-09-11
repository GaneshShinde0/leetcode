class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer,Integer> hm= new HashMap<>();
        int val=100000, freq=0;
        for(int i:nums){
            if(i%2==0){
                int curr = hm.getOrDefault(i,0)+1;
                hm.put(i,curr);
                // Update smallest with greatest frequency
                if(curr>freq || curr==freq && i<val){
                    val =i;
                    freq = curr;
                }
            }
        }

        return freq==0?-1:val;
    }
}

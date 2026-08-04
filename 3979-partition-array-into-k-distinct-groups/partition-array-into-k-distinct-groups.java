class Solution {
    public boolean partitionArray(int[] nums, int k) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int i:nums){
            freq.put(i, freq.getOrDefault(i,0)+1);
        }
        List<Integer> li = new ArrayList<>(freq.values());
        Collections.sort(li);
        int left = 0, right = li.size()-1;
        return (1l*li.get(right)*k<=nums.length && nums.length%k==0 );
    }
}
class Solution {
    public int maxDistinctElementsInitialSolution(int[] nums, int k) {
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i:nums){
            int start = hm.getOrDefault(i,i-k);
            int end = i+k;
            while(set.contains(start)&&start<end){
                start++;
            }
            hm.put(i,start);
            set.add(start);
        }
        return set.size();
    }

    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        long lastVisited = Long.MIN_VALUE;
        for(int num:nums){
            long curr = Math.max(num-k,lastVisited+1);
            if(curr<=num+k){
                lastVisited=curr;
                count++;
            }
        }
        return count;
    }
}
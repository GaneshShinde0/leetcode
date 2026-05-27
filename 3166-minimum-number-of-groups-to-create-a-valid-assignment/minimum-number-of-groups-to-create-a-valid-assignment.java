class Solution {
    public int minGroupsForValidAssignment(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        int min = nums.length;
        for(int v : map.values()) {
            min = Math.min(min, v);
        }

        for(int size = min; size >= 1; --size) {
            int numGroups = groupify(map, size); 
            if(numGroups > 0) return numGroups;
        }
        
        return nums.length;
    }
    
    private int groupify(Map<Integer, Integer> map, int size) {
        int groups = 0;
        int next = size + 1;
        
        for(int value : map.values()) {
            int numGroups = value / next;
            int remaining = value % next;

            if(remaining == 0) {
                groups += numGroups;
            }else if(numGroups >= size - remaining) {
                groups += numGroups + 1;
            } 
            else {
                return 0;
            }
        }
        return groups;
    }
}
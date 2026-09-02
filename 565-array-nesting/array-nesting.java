class Solution {
    public int arrayNesting(int[] nums) {
        int res = 0;
        HashMap<Integer,Integer> visited = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(visited.containsKey(nums[i])) continue;
            res = Math.max(res, dfs(nums, nums[i], visited));
        }
        return res;
    }
    private int dfs(int[] nums, int curr, HashMap<Integer, Integer> visited){
        if(visited.containsKey(curr)) return visited.get(curr);
        visited.put(curr,0);
        int sub = 1+dfs(nums, nums[curr], visited);
        visited.put(curr, sub);
        return sub;
    }
}
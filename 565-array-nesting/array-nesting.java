class Solution{
    public int arrayNesting(int[] nums) {
        int res = 0;
        HashSet<Integer> visited = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(visited.contains(nums[i])) continue;
            int start = nums[i], count = 0;
            do{
                visited.add(start);
                start = nums[start];
                count++;
            }while(start!=nums[i]);
            res = Math.max(res, count);
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
class SolutionInitial{
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
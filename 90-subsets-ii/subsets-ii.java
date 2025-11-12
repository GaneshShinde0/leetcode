class Solution {
    public List<List<Integer>> subsetsWithDupInitial(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        List<Integer> li = new ArrayList<>();
        recurseInitial(set, nums,li, 0, nums.length);
        return new ArrayList<>(set);
    }

    private void recurseInitial(Set<List<Integer>> set, int[] nums,List<Integer> li, int start, int end){
        // Collections.sort(li); // This is not needed and adds about 8 ms to result.
        set.add(new ArrayList<>(li));
        for(int i= start; i<end;i++){
            li.add(nums[i]);
            recurseInitial(set, nums, li, i+1, end);
            li.remove(li.size()-1);
            recurseInitial(set, nums, li, i+1, end);
        }
    }

    // 4 ms beats 12%
    public List<List<Integer>> subsetsWithDupWithoutForLoop(int[] nums) {
        Set<List<Integer>> rs = new HashSet<>();
        Arrays.sort(nums);
        List<Integer> li = new ArrayList<>();
        recurseWithoutForLoop(rs, nums,li, 0, nums.length);
        return new ArrayList(rs);
    }

    private void recurseWithoutForLoop(Set<List<Integer>> res, int[] nums,List<Integer> li, int start, int end){
        if(start==end){
            res.add(new ArrayList<>(li));
            return;
        }
        li.add(nums[start]);
        recurseWithoutForLoop(res, nums, li, start+1, end);
        li.remove(li.size()-1);
        recurseWithoutForLoop(res, nums, li, start+1, end);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> li = new ArrayList<>();
        recurse(res, nums,li, 0, nums.length);
        return res;
    }

    private void recurse(List<List<Integer>> res, int[] nums,List<Integer> li, int start, int end){
        res.add(new ArrayList<>(li));
        for(int i= start; i<end;i++){
            if(i>start && nums[i]==nums[i-1]) continue;
            li.add(nums[i]);
            recurse(res, nums, li, i+1, end);
            li.remove(li.size()-1);
        }
    }
}
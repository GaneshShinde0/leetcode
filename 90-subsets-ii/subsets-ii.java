class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        List<Integer> li = new ArrayList<>();
        recurse(set, nums,li, 0, nums.length);
        return new ArrayList<>(set);
    }

    private void recurse(Set<List<Integer>> set, int[] nums,List<Integer> li, int start, int end){
        // Collections.sort(li);
        set.add(new ArrayList<>(li));
        for(int i= start; i<end;i++){
            li.add(nums[i]);
            recurse(set, nums, li, i+1, end);
            li.remove(li.size()-1);
            recurse(set, nums, li, i+1, end);
        }
    }
}
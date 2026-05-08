class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        recurse(0,nums,new ArrayList<>(), result);
        return new ArrayList<>(result);
    }

    private void recurse(int start, int[] nums,List<Integer> curr, Set<List<Integer>> result){
        if(start<=nums.length && curr.size()>=2){
            result.add(new ArrayList<>(curr));
        }
        for(int i = start; i<nums.length;i++){
            if(curr.size()==0|| curr.get(curr.size()-1)<=nums[i]){
                curr.add(nums[i]);
                recurse(i+1,nums, curr, result);
                curr.remove(curr.size()-1);
            }
        }
    }
}
class SolutionInitial {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        recurse(0,nums,new ArrayList<>(), result);
        return new ArrayList<>(result);
    }

    private void recurse(int start, int[] nums,List<Integer> curr, Set<List<Integer>> result){
        if(start<=nums.length && curr.size()>=2){
            result.add(new ArrayList<>(curr));
        }
        for(int i = start; i<nums.length;i++){
            boolean addedTwo = false;
            boolean addedOne = false;
            if(curr.size()==0 &&start<i && nums[i]>=nums[start]){
                curr.add(nums[start]);
                curr.add(nums[i]);
                addedTwo = true;
            }else if(curr.size()>=2 && nums[i]>=curr.get(curr.size()-1)){
                curr.add(nums[i]);
                addedOne = true;
            }
            recurse(i+1,nums, curr, result);
            if(addedTwo){
                curr.remove(curr.size()-1);
                curr.remove(curr.size()-1);
            }else if(addedOne){
                curr.remove(curr.size()-1);
            }
            // recurse(i,nums, curr, result);
        }
    }
}
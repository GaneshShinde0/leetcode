class Solution {
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        int steps = moveFrom.length;
        Set<Integer> numSet = new HashSet<>();
        for(int i:nums) numSet.add(i);
        for(int i=0;i<steps;i++){
            numSet.remove(moveFrom[i]);
            numSet.add(moveTo[i]);
        }
        List<Integer> result =new ArrayList<>(numSet);
        Collections.sort(result);
        return result;
    }
}
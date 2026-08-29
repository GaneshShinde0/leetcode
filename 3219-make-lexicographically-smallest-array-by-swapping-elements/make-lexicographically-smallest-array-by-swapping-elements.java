class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[] sorted = Arrays.copyOf(nums,n);
        Arrays.sort(sorted);
        HashMap<Integer, LinkedList<Integer>> groupToList = new HashMap<>();
        HashMap<Integer, Integer> numToGroup = new HashMap<>();
        int prevElem = sorted[0], currGroup=0;
        numToGroup.put(sorted[0],currGroup);
        for(int i=0;i<n;i++){
            if(sorted[i]-prevElem>limit){
                currGroup++;
            }
            numToGroup.put(sorted[i],currGroup);
            prevElem = sorted[i];
            groupToList.computeIfAbsent(currGroup,x-> new LinkedList<Integer>()).add(sorted[i]);
        }
        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            int group = numToGroup.get(num);
            nums[i] = groupToList.get(group).pop();
        }
        return nums;
    }
}
/*


*/
class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int[] numsSorted = Arrays.copyOf(nums,nums.length);
        Arrays.sort(numsSorted); // Regular lexicographical sorting.
        int currGroup = 0;
        HashMap<Integer, Integer> numToGroup = new HashMap<>();
        numToGroup.put(numsSorted[0], currGroup);

        HashMap<Integer, LinkedList<Integer>> groupToList = new HashMap<>();
        groupToList.put(currGroup,new LinkedList<Integer>(Arrays.asList(numsSorted[0])));

        for(int i=1;i<nums.length;i++){
            if(Math.abs(numsSorted[i]-numsSorted[i-1])>limit){
                currGroup++;
            }
            numToGroup.put(numsSorted[i], currGroup);
            
            // Add element to sorted group list
            if(!groupToList.containsKey(currGroup)){
                groupToList.put(currGroup, new LinkedList<Integer>());
            }

            groupToList.get(currGroup).add(numsSorted[i]);
        }

        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            int group = numToGroup.get(num);
            nums[i] = groupToList.get(group).pop();
        }
        return nums;
    }
}
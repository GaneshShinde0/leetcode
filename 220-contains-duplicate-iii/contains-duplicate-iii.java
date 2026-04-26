/*
1=>0
2=>1
3=>2

*/

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        for(int i=0;i<nums.length;i++){
            Map.Entry<Integer,Integer> ceil = treeMap.ceilingEntry(nums[i]);
            Map.Entry<Integer,Integer> floor = treeMap.floorEntry(nums[i]);
            while(ceil!=null && i-ceil.getValue()>indexDiff){
                treeMap.remove(ceil.getKey());
                ceil = treeMap.ceilingEntry(nums[i]);
            }
            while(floor!=null && i-floor.getValue()>indexDiff){
                treeMap.remove(floor.getKey());
                floor = treeMap.floorEntry(nums[i]);
            }
            if(ceil!=null && i-ceil.getValue()<=indexDiff && (ceil.getKey()-nums[i])<=valueDiff){
                return true;     
            }
            if(floor!=null && i-floor.getValue()<=indexDiff && (nums[i]-floor.getKey())<=valueDiff){
                return true;     
            }
            System.out.println(ceil+" , "+floor);
            treeMap.put(nums[i],i);
        }
        return false;
    }
}
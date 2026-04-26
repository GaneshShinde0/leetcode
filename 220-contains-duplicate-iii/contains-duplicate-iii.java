/*
1=>0
2=>1
3=>2

*/

class Solution {
    public boolean containsNearbyAlmostDuplicateInitial(int[] nums, int indexDiff, int valueDiff) {
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
            // System.out.println(ceil+" , "+floor);
            treeMap.put(nums[i],i);
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0;i<nums.length;i++){
            Integer ceil = set.ceiling(nums[i]);
            Integer floor = set.floor(nums[i]);
            if(ceil!=null && ceil-nums[i]<=valueDiff) return true;
            if(floor!=null && nums[i]-floor<=valueDiff) return true;
            set.add(nums[i]);
            if(set.size()>indexDiff) set.remove(nums[i-indexDiff]);
        }
        return false;
    }
}
/*
1=>0
2=>1
3=>2

*/

class Solution {
    /*To calculate the bucket ID (similar to Math.floorDiv) without using the library, you need to handle how Java's division behaves for negative numbers. In Java, / truncates toward zero, whereas floorDiv truncates toward negative infinity.*/
    private long getIDCustom(long x, long w) {
        if (x >= 0) {
            return x / w;
        } else {
            return (x + 1) / w - 1;
        }
    }
    private int getId(int x, int w){
        return Math.floorDiv(x,w);
    }
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if(valueDiff<0) return false;
        Map<Integer, Integer> buckets = new HashMap<>();
        int w = valueDiff+1;
        for(int i=0;i<nums.length;i++){
            int bucket = getId(nums[i],w);
            if(buckets.containsKey(bucket)) return true;

            if(buckets.containsKey(bucket-1) && Math.abs(nums[i]-buckets.get(bucket-1))<w) return true;
            if(buckets.containsKey(bucket+1) && Math.abs(nums[i]-buckets.get(bucket+1))<w) return true;

            buckets.put(bucket, nums[i]);
            if(i>=indexDiff) buckets.remove(getId(nums[i-indexDiff],w));
        }
        return false;
    }   














    public boolean containsNearbyAlmostDuplicateUsingTreeMap(int[] nums, int indexDiff, int valueDiff) {
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

    public boolean containsNearbyAlmostDuplicateUsingSet(int[] nums, int indexDiff, int valueDiff) {
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
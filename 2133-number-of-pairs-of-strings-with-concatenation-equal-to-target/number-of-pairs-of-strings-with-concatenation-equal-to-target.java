class Solution {
    public int numOfPairs(String[] nums, String target) {
        int count = 0, n = target.length();
        Map<Integer,Integer> prefix = new HashMap<>(), suffix = new HashMap<>();
        for(String num:nums){
            int size = num.length();
            if(target.startsWith(num)) count += suffix.getOrDefault(n-size,0);
            if(target.endsWith(num)) count +=prefix.getOrDefault(n-size,0);
            if(target.startsWith(num)) prefix.put(size, 1+prefix.getOrDefault(size,0));
            if(target.endsWith(num)) suffix.put(size, 1+suffix.getOrDefault(size,0));
        }
        return count;
    }
}
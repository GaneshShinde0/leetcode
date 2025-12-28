class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        int n  = nums.length;
        List<Integer> li = new ArrayList<>();
        for(int i:nums){
            hm.put(i, hm.getOrDefault(i,0)+1);
            if(hm.get(i)==(n/3+1)) li.add(i);
        }
        return li;
    }
}
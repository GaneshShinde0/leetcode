class Solution {
    public int smallestAbsent(int[] nums) {
        double sum = 0;
        Set<Integer> set = new HashSet<>();
        for(int i:nums){
            sum+=i;
            set.add(i);
        }
        int res = (int) Math.floor(sum/nums.length);
        res++;
        if(res<=0) res=1;
        while(set.contains(res)){
            res++;
        }
        
        return res;
    }
}
class Solution {
    public long beautifulSubarrays(int[] nums) {
        HashMap<Long, Long> hm = new HashMap<>();
        hm.put(0l,1l);
        long currXor = 0;
        long res = -1;
        for(int num:nums){
            currXor ^=num;
            if(hm.containsKey(currXor)) res+=hm.get(currXor);
            hm.put(currXor,hm.getOrDefault(currXor,0l)+1);
        }
        return res+1;
    }
}

/*
4:1
7:1
6:1
4:2

*/
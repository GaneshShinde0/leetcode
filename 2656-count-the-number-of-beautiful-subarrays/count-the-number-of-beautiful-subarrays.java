class Solution {
    public long beautifulSubarrays(int[] nums) {
        HashMap<Long, Long> hm = new HashMap<>();
        // Initial put(0, 1) removed
        
        long currXor = 0;
        long res = 0;
        
        for (int num : nums) {
            currXor ^= num;

            // 1. Explicitly check if the prefix from the start is valid
            if (currXor == 0) {
                res++;
            }

            // 2. Check for subarrays starting after index 0
            if (hm.containsKey(currXor)) {
                res += hm.get(currXor);
            }

            // 3. Update the map
            hm.put(currXor, hm.getOrDefault(currXor, 0L) + 1);
        }
        return res;
    }

    public long beautifulSubarrays1(int[] nums) {
        HashMap<Long, Long> hm = new HashMap<>();
        hm.put(0l,1l);
        long currXor = 0;
        long res = 0;
        for(int num:nums){
            currXor ^=num;
            if(hm.containsKey(currXor)) res+=hm.get(currXor);
            hm.put(currXor,hm.getOrDefault(currXor,0l)+1);
        }
        return res;
    }
}

/*
0:1 
4:1
7:1
6:1
4:2

*/
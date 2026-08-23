class Solution {
    public int divisibleTripletCount(int[] nums, int d) {
        int n = nums.length;
        int res = 0;
        HashMap<Integer,Integer> leftMap = new HashMap<>();
        HashMap<Integer,Integer> rightMap = new HashMap<>();
        for(int i=0;i<n;i++){
            nums[i]%=d;
            if(i>1)rightMap.put(nums[i],rightMap.getOrDefault(nums[i],0)+1);
        }
        leftMap.put(nums[0],1);
        int left = 0, mid = 1, right = 2;
        while(mid<n-1){
            int midElem = nums[mid];
            for(Map.Entry<Integer, Integer> e: leftMap.entrySet()){
                int withLeft = (e.getKey()+midElem)%d;
                res+=e.getValue()*rightMap.getOrDefault((d-withLeft)%d,0);
            }
            leftMap.put(nums[mid],leftMap.getOrDefault(nums[mid],0)+1);
            rightMap.put(nums[mid+1],rightMap.getOrDefault(nums[mid+1],0)-1);
            mid++;
        }
        return res;
    }
}
class FindSumPairs {

    int[] nums1;
    int[] nums2;
    Map<Integer,Integer> hs = new HashMap<>();
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1=nums1;
        this.nums2=nums2;
        for(int j:nums2){
            hs.put(j,hs.getOrDefault(j,0)+1);
        }
        System.out.println(hs);

    }
    
    public void add(int index, int val) {
        hs.put(nums2[index],hs.getOrDefault(nums2[index],0)-1);
        this.nums2[index]+=val;
        hs.put(nums2[index],hs.getOrDefault(nums2[index],0)+1);
    }
    
    public int count(int tot) {
        int ans = 0;
        for(int a:nums1){
            ans+= hs.getOrDefault(tot-a,0);
        }
        return ans;
    }
}

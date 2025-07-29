class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int maxOr = 0, n= nums.length;
        int[] res = new int[n];
        int[] pos = new int[31];
        Arrays.fill(pos, -1);
        for(int i:nums) maxOr |=i;
        for(int i=n-1;i>=0; i--){
            int j = i;
            for(int bit = 0; bit<31; bit++){
                if((nums[i]& (1<<bit))==0){
                    if(pos[bit]!=-1){
                        j = Math.max(j,pos[bit]);
                    }
                }else{
                    pos[bit] = i;
                }
            }
            res[i] = j-i+1;
        }
        return res;

    }
}
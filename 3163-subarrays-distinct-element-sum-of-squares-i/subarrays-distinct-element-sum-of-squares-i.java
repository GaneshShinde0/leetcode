class Solution {
    public int sumCounts(List<Integer> nums) {
        int res = 0;
        for(int i=0;i<nums.size();i++){
            int distinct = 0;
            int[] freq = new int[101];
            for(int j=i;j<nums.size();j++){
                freq[nums.get(j)]++;
                if(freq[nums.get(j)]==1){
                    distinct++;
                }
                // System.out.println(distinct);
                res  += distinct*distinct;
            }
        }
        return res;
    }
}
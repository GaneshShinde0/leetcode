import java.math.BigInteger;

class Solution {
    private static final int MOD = 1_000_000_007;
    public List<Integer> powerUpdate(int[] nums, int p, int[][] queries) {
        List<Integer> ans = new ArrayList<Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
        }

        for(int i=0;i<queries.length;i++){
            int low = 0, high = list.size()-1;
            while(low<=high){
                int mid = (low+high)/2;
                if(list.get(mid)>queries[i][0]){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }
            list.add(low, queries[i][0]);
            int kthLargestValue = list.get(list.size()-queries[i][1]);
            BigInteger t = BigInteger.valueOf(p).modPow(BigInteger.valueOf(kthLargestValue),BigInteger.valueOf(MOD));
            p = t.intValue();
            ans.add(p);
        }
        return ans;
    }
}
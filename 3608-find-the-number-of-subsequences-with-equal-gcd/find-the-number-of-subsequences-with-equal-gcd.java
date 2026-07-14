class Solution {
    int[] nums;
    HashMap<Integer, Integer> hm;
    private int MOD = 1_000_000_007;
    public int subsequencePairCount(int[] nums) {
        this.nums = nums;
        this.hm = new HashMap<>();
        return recurse(0, 0,0);
    }

    private int recurse(int i, int gcd1, int gcd2){
        if(i==nums.length){
            if(gcd1==0 && gcd2==0) return 0;
            return gcd1==gcd2?1:0;
        }
        int key = i+gcd1*1000+gcd2*1000000;
        if(hm.containsKey(key)) return hm.get(key);
        long longRes = 1l*recurse(i+1, gcd1, gcd2) + recurse(i+1, gcd(nums[i], gcd1), gcd2) + recurse(i+1, gcd1, gcd(nums[i], gcd2));
        int res = (int) (longRes%MOD);
        hm.put(key, res);
        return res;
    }
    private int gcd(int a, int b){
        return b==0?a:gcd(b,a%b);
    }
}
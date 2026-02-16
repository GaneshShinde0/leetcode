class Solution {

    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int sum = 0,res=0;
        hm.put(0,-1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i]==1?1:-1;
            if(hm.containsKey(sum)){
                res = Math.max(res,i-hm.get(sum));
            }else{
                hm.put(sum,i);
            }
        }
        return res;
    }
}

/*

001101011100
*/
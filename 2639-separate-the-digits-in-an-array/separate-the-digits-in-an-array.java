class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> digits = new ArrayList<>();
        for(int i=nums.length-1;i>=0;i--){
            int curr = nums[i];
            while(curr>0){
                int rem = curr%10;
                curr=curr/10;
                digits.add(rem);
            }
        }
        int size = digits.size();
        int[] res = new int[size];
        for(int i=0;i<size;i++){
            res[i]=digits.get(size-i-1);
        }
        return res;
    }
}
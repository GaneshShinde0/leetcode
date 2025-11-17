class NumArray {

    private int[] b, nums;
    private int len;
    public NumArray(int[] nums) {
        this.nums = nums;
        len = (int) Math.ceil(Math.sqrt(nums.length));
        b = new int[len];
        for(int i=0;i<nums.length; i++){
            b[i/len] += nums[i];
        }
        System.out.println(len);
    }
    
    public void update(int index, int val) {
        b[index/len] = b[index/len] - nums[index] + val;
        nums[index] = val;
    }
    
    public int sumRange(int left, int right) {
        int sum = 0;
        int start = left/len;
        int end = right/len;
        if(start==end){
            for(int i=left;i<=right;i++){
                sum+=nums[i];
            }
        }else{
            for(int i=left;i<(start+1)*len;i++){
                sum+=nums[i];
            }
            for(int i=start+1;i<end;i++){
                sum+=b[i];
            }
            for(int i=end*len;i<=right;i++){
                sum+=nums[i];
            }
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
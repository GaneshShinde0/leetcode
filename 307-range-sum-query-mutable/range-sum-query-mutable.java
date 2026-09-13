class NumArraySQRTDecomposition{

    private int[] b, nums;
    private int len;
    public NumArraySQRTDecomposition(int[] nums) {
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

class NumArray{
    int[] tree;
    int n;
    public NumArray(int[] nums) {
        if (nums.length > 0) {
            n = nums.length;
            tree = new int[n * 2];
            buildTree(nums);
        }
    }
    private void buildTree(int[] nums) {
        for (int i = n, j = 0;  i < 2 * n; i++,  j++)
            tree[i] = nums[j];
        for (int i = n - 1; i > 0; --i)
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
    }

    void update(int pos, int val) {
        pos += n;
        tree[pos] = val;
        while (pos > 0) {
            int left = pos;
            int right = pos;
            if (pos % 2 == 0) {
                right = pos + 1;
            } else {
                left = pos - 1;
            }
            // parent is updated after child is updated
            tree[pos / 2] = tree[left] + tree[right];
            pos /= 2;
        }
    }

    public int sumRange(int l, int r) {
        // get leaf with value 'l'
        l += n;
        // get leaf with value 'r'
        r += n;
        int sum = 0;
        while (l <= r) {
            if ((l % 2) == 1) {
                sum += tree[l];
                l++;
            }
            if ((r % 2) == 0) {
                sum += tree[r];
                r--;
            }
            l /= 2;
            r /= 2;
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
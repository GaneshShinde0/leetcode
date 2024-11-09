class Solution {

    private int[] nums;
    private Random random;

    public Solution(int[] nums) {

        this.nums = nums;
        random = new Random();    
    }
    
    public int[] reset() {
        return nums;
    }
    
    public int[] shuffle() {
        if(nums==null) return null;
        int[] a = nums.clone();
        for(int j=1;j<a.length;j++){
            int i = random.nextInt(j+1);
            swap(a, i, j);
        }
        return a;
    }

    private void swap(int[] a, int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j]=t;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();

 class Solution {
    int data[];
    public Solution(int[] nums) {
        data = new int[nums.length];

        for(int i=0;i<nums.length;i++)  data[i] = nums[i];
    }
    
    public int[] reset() {
        return data;
    }
    
    int Random(){
        Random rand = new Random();

        return rand.nextInt(data.length);
    }

    public int[] shuffle() {
        
        int[] ans = new int[data.length];
        boolean added[] = new boolean[data.length];

        for(int i=0;i<ans.length;i++){
            int index = Random();
            if(!added[index]){
                added[index] = true;
                ans[i] = data[index];
            }
            else i--;

        }    
        return ans;
        // return data;
    }
}

 */

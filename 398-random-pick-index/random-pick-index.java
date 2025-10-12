class Solution {
    // Using Reservoir Sampling.
    private int[] nums;
    public Solution(int[] nums) {
        this.nums = nums;
    }
    
    public int pick(int target) {
        int count =0,pickedIndex = 0;
        Random random = new Random();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                count++;
                if((random.nextInt(count)+1)==count){
                    pickedIndex = i;
                }
            }
        }
        return pickedIndex;
    }
}


// class Solution {
//     HashMap<Integer, List<Integer>> hm;
//     public Solution(int[] nums) {
//         hm = new HashMap<>();
//         for(int i=0;i<nums.length;i++){
//             hm.computeIfAbsent(nums[i],k->new ArrayList<>()).add(i);
//         }
//     }
    
//     public int pick(int target) {
//         List<Integer> li = hm.get(target);
//         return li.get((int) (li.size()*(Math.random())));
//     }
// }

// /**
//  * Your Solution object will be instantiated and called as such:
//  * Solution obj = new Solution(nums);
//  * int param_1 = obj.pick(target);
//  */
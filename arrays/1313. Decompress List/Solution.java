class Solution {
    public int[] decompressRLElist5ms(int[] nums) {
        List<Integer> li = new ArrayList<>();
        for(int i=0;i<nums.length;i+=2){
            while(nums[i]>0){
                li.add(nums[i+1]);
                nums[i]--;
            }
        }
        int[] res = new int[li.size()];
        for(int i=0;i<li.size();i++){
            res[i]=li.get(i);
        }
        return res;

    }

    public int[] decompressRLElist(int[] nums) {
       int size =0;

       for(int i=0;i<nums.length;i+=2){
         size += nums[i];
       }

       int[] result = new int[size];

       int start=0;
       for(int i=0;i<nums.length;i+=2){
        Arrays.fill(result,start,start+nums[i],nums[i+1]);
        start += nums[i];
       }
       return result;
    }
}

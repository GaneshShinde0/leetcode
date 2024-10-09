class N80RemoveDuplicatesFromSortedArray2 {
    public int removeDuplicates(int[] nums) {
        int[] arr = new int[nums.length];
        int pointer=2;
        for(int i=2;i<nums.length;i++){
            if(!(nums[pointer-2]==nums[i]&&nums[pointer-1]==nums[i])){
                nums[pointer]=nums[i];
                pointer++;
            }
        }
        return pointer;
    }
}

class MinimumNumberGame {
    public int[] numberGame2Ms(int[] nums) {
        Arrays.sort(nums);
        int i=1;
        while(i<(nums.length)){
            int temp=nums[i];
            nums[i]=nums[i-1];
            nums[i-1]=temp;
            i+=2;
        }
        return nums;
    }

    public int[] numberGame(int[] nums) {
        int[] arr = new int[nums.length];
        for(int i = 0 ;i<nums.length;i++){
            int alice = findMin(nums);
            int bob = findMin(nums);
            arr[i] = bob;
            i++;
            arr[i] = alice;
            /* Above 3 lines are same as
            arr[i++] = bob;
            arr[i] = alice;
            */
        }
        return arr;
    }

    public static int findMin(int[] nums){
        int min = Integer.MAX_VALUE;
        int index = -1;
        for(int i = 0 ; i < nums.length;i++){
            if(nums[i] < min){
                min = nums[i];
                index = i;
            }
        }
        if(index >= 0){
            nums[index] = Integer.MAX_VALUE;
        }
        return min;
    }
}

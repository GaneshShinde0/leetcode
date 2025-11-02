class Solution {
    public List<Integer> transformArray(int[] nums) {
        int n = nums.length;
        boolean flag = true;
        int[] arr = new int[n];
        while(flag){
            flag = false;
            arr = Arrays.copyOf(nums,n);
            for(int i=1;i<n-1;i++){
                if(arr[i]<arr[i-1] && arr[i]<arr[i+1]){
                    nums[i]+=1;
                    flag = true;
                }
                if(arr[i]>arr[i-1] && arr[i]>arr[i+1]){
                    nums[i]-=1;
                    flag = true;
                }
            }
        }
        // int sum = 0;
        // for(int i=1;i<n-1;i++){
        //     sum+=arr[i];
        // }
        // int avg = (int) Math.ceil(sum*1.0/(n-2));
        // for(int i=1;i<n-1;i++){
        //     arr[i]=avg;
        // }
        return Arrays.stream(nums).boxed().toList();
    }
}
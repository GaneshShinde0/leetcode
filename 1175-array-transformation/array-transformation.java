class Solution {
    public List<Integer> transformArray(int[] arr) {
        
        int previous = arr[0];
        boolean updateMade = true;

        while (updateMade) {

            updateMade = false;

            for (int i = 1; i < arr.length - 1; i++) {

                int current = arr[i];
                int next = arr[i + 1];

                if (current > previous && current > next) {
                    arr[i]--;
                    updateMade = true;
                } else if (current < previous && current < next) {
                    arr[i]++;
                    updateMade = true;
                }

                previous = current;

            }

            previous = arr[0];
        }

        ArrayList<Integer> returnList = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            returnList.add(arr[i]);
        }
        
        return returnList;
    }
    public List<Integer> transformArrayInitial(int[] nums) {
        int n = nums.length;
        boolean flag = true;
        int[] arr = new int[n];
        while(flag){
            flag = false;
            arr = Arrays.copyOf(nums,n); // We are taking copy to avoid future comparisons of current element of array. (as if we are coparing arr[i+1] then if previously arr[i] was updated... it will compare with updated value... which needs to be avoided as we want to compare with original)
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
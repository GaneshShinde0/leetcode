class Solution {
    public int[] sortArray(int[] nums) {
        int start =0, end = nums.length;
        mergeSort(nums, start, end-1);
        return nums;
    }

    private void mergeSort(int[] nums, int start, int end){

        // Base Case : considering >= as we use mid+1;
        if(start>=end) return;

        int mid = (start+end)/2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid+1,end);
        merge(nums,start,mid,end);

    }
    
    private void merge(int[] arr, int start,int mid,int end){
        int left = start, right = mid+1;
        int[] temp = new int[arr.length];
        int i=0;
        while(left<=mid && right<=end){
            if(arr[left]<=arr[right]){
                temp[i] = arr[left];
                left++;
            }else{
                temp[i] = arr[right];
                right++;
            }
            i++;
        }

        while(left<=mid){
            temp[i] = arr[left];
            left++;
            i++;
        }
        while(right<=end){
            temp[i] = arr[right];
            right++;
            i++;
        }
        for(int j=start;j<=end;j++){
            arr[j] = temp[j-start];
        }
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
class Solution {
    public long countPairs(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int count = 0;
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=nums1[i]-nums2[i];
        }
        Arrays.sort(arr);

        long res = 0;
        int left = 0;
        int right = n-1;
        while(left<right){
            // Left makes a valid pair with right
            // Right also makes a valid pair with the indices between the pointers.
            if(arr[left]>-arr[right]){
                res += right-left;
                right--;
            }else{
                left++;
            }
        }
        return res;
    }
}
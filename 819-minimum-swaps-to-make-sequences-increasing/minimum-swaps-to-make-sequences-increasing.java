class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] swap= new int[100000];
        int[] notSwap = new int[100000];
        swap[0]=1;
        for(int i=1;i<n;i++){
            notSwap[i] = swap[i] = n;
            if(nums1[i-1]<nums1[i] && nums2[i-1]<nums2[i]){
                swap[i]=swap[i-1]+1;
                notSwap[i] = notSwap[i-1];
            }
            if(nums1[i-1]<nums2[i] && nums2[i-1]<nums1[i]){
                swap[i] = Math.min(swap[i],notSwap[i-1]+1);
                notSwap[i] = Math.min(notSwap[i],swap[i-1]);
            }
        }
        return Math.min(swap[n-1],notSwap[n-1]);
    }
}
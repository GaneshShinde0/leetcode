
class Solution1 {
    public int minOperations(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int count1 = 0;// When last elements are not swapped.
        int count2 = 0;// When last elements are swapped.
        int min = Math.min(nums1[n-1],nums2[n-1]), max = Math.max(nums1[n-1],nums2[n-1]);
        for(int i=0;i<n;i++){
            int n1 = nums1[i], n2 = nums2[i];
            if(Math.max(n1,n2)>max) return -1; // No swap will work.
            if(Math.min(n1,n2)>min) return -1; // No swap will work.
            if(n1>nums1[n-1]||n2>nums2[n-1]) count1++; // When last elements are not swapped.
            if(n1>nums2[n-1]||n2>nums1[n-1]) count2++; // When last elements are swapped.
        }
        return Math.min(count1,count2);
    }
}
class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int a = nums1[n-1];
        int b = nums2[n-1];

        int swap1 = 0;
        int flag1 = 1;
        // option1 : if we don't swap the last elements of both array
        for(int i=0;i<n-1;i++){
            if(nums1[i]<=a && nums2[i]<=b)
                continue;
            else if(nums2[i]<=a && nums1[i]<=b)
                swap1++;
            else{
                flag1 = 0;
                break;
            }
        }
        // option2 : if we swap the last elements of both array, i.e. count2 = 1
        int swap2 = 1;
        int flag2 = 1;
        for(int i=0;i<n-1;i++){
            if(nums1[i]<=b && nums2[i]<=a)
                continue;
            else if(nums2[i]<=b && nums1[i]<=a)
                swap2++;
            else{
                flag2 = 0;
                break;
            }
        }
        if(flag1==0 && flag2==0)
            return -1;
        return Math.min(swap1,swap2);
    }
}
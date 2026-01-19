class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 =0, p2 = 0,p3=0;
        int[] res = new int[m+n];
        while(p1<m||p2<n){
            if((p1<m && p2<n)&& nums1[p1]<nums2[p2]){
                res[p3]=nums1[p1];
                p1++;
            }else if((p1<m && p2<n) && nums1[p1]>=nums2[p2]){
                res[p3]=nums2[p2];
                p2++;
            }else if(p1<m){
                res[p3]=nums1[p1];
                p1++;
            }else if(p2<n){
                res[p3]=nums2[p2];
                p2++;
            }
            p3++;
        }
        // System.out.println(Arrays.toString(res));
        if(nums1.length>=nums2.length){
            for(int i=0;i<m+n;i++){
                nums1[i]=res[i];
            }
        }else{
            for(int i=0;i<m+n;i++){
                nums2[i]=res[i];
            }
        }
    }
}
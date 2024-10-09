class N4FindMedianOfSortedArrays {
    public double findMedianSortedArraysNaive(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length+nums2.length];
        int i=0;
        for(int num:nums1){
            arr[i]=num;
            i+=1;
        }
        for(int num:nums2){
            arr[i]=num;
            i++;
        }
        int length= arr.length;
        Arrays.sort(arr);
        if(arr.length%2==0){
            return (arr[length/2]+arr[(length-1)/2])/2.0;
        }
        return arr[length/2];
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lenA = nums1.length;
        int lenB = nums2.length;

        if (lenA > lenB)
            return findMedianSortedArrays(nums2, nums1);

        if (lenA == 0)
            return (nums2[(lenB - 1) / 2] + nums2[lenB / 2]) / 2.0;

        int len = lenA + lenB;

        // We only perform the binary search against nums1 so here only use a pair of index for nums1
        int startA = 0;
        int endA = lenA;

        // The total number of elements on the left-hand side of nums1's cut line
        int cutA;
        // The total number of elements on the left-hand side of nums2's cut line
        int cutB;

        while (startA <= endA) {
            cutA = startA + (endA - startA) / 2;
            cutB = (len + 1) / 2 - cutA;

            double L1 = (cutA == 0) ? Integer.MIN_VALUE : nums1[cutA - 1];
            double L2 = (cutB == 0) ? Integer.MIN_VALUE : nums2[cutB - 1];
            double R1 = (cutA == lenA) ? Integer.MAX_VALUE : nums1[cutA];
            double R2 = (cutB == lenB) ? Integer.MAX_VALUE : nums2[cutB];

            if (L1 > R2)
                endA = cutA - 1;
            else if (L2 > R1)
                startA = cutA + 1;
            else {
                if (len % 2 == 0)
                    return (Math.max(L1, L2) + Math.min(R1, R2)) / 2;
                else
                    return Math.max(L1, L2);
            }
        }
        return -1;
    }
}

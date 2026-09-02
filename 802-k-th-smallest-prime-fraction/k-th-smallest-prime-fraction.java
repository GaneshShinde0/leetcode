class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        double left = 0, right = 1;
        while(left<right){
            double mid = (left+right)/2;
            double maxFraction = 0;
            int totalSmallerFractions = 0, numeratorIdx=0, denomIdx=0, j = 1;
            for(int i=0;i<n;i++){
                while(j<n && arr[i]*1.0/arr[j]>=mid) j++;
                totalSmallerFractions += n-j;
                if(j==n) break;

                double fraction = (double) arr[i]/arr[j];
                if(fraction>maxFraction){
                    numeratorIdx = i;
                    denomIdx = j;
                    maxFraction = fraction;
                }
            }
            if(totalSmallerFractions==k){
                return new int[]{arr[numeratorIdx],arr[denomIdx]};
            }else if(totalSmallerFractions>k){
                right = mid; // Meaning number of smaller fractions we found for mid suppose 0.75, were larger. so we reduce our boundary;
            }else{
                left = mid;
            }
        }
       return new int[]{};
    }
}
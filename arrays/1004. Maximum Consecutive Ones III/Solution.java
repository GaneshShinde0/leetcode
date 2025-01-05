class Solution {
    public int longestOnesOther(int[] A, int K) {
        int i = 0, j;
        for (j = 0; j < A.length; ++j) {
            if (A[j] == 0) K--;
            if (K < 0 && A[i++] == 0) K++;
        }
        return j - i;
    }

    public int longestOnes(int[] a, int k){
        int left=0, right=0, max=0;
        int numZeroes = 0;
        for(right=0; right<a.length; right++){
            if(a[right]==0) numZeroes++;
            if(numZeroes>k){
                if(a[left]==0)numZeroes--;
                left++;
            }
            if(numZeroes<=k){
                max = Math.max(max, right-left+1);
            }
        }
        return max;
    }
}

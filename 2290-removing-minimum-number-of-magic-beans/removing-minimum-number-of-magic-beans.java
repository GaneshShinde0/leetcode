class Solution {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        long N =beans.length, ans = Long.MAX_VALUE, sum = 0;
        for(int b:beans) sum += b;
        for(int i=0;i<N;i++){
            ans = Math.min(ans, sum-(N-i)*beans[i]); // for (N-i)*beans[i] to remain we have to subtract them from total...
            // We have to minimize that subtraction;
        }
        return ans;
    }
}
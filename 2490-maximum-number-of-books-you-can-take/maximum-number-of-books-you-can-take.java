/*


*/
class Solution {
    public long maximumBooks(int[] books) {
        int n = books.length, min = books[n-1];
        Deque<Integer> dq = new ArrayDeque<>();
        long[] dp = new long[n];
        for(int i=0;i<n;i++){
            while(dq.size()>0 && books[dq.peekLast()]-dq.peekLast()>=books[i]-i){
                dq.pollLast();
            }
            if(dq.size()==0){
                dp[i] = calculateSum(books,0,i);
            }else{
                int j= dq.peekLast();
                dp[i] = dp[j]+calculateSum(books, j+1,i);
            }
            dq.addLast(i);
        }
        return Arrays.stream(dp).max().getAsLong();
    }
    private long calculateSum(int[] books, int l, int r) {
        int cnt = Math.min(books[r],r-l+1); // Number of elements in sequence. (suppose )
        return (2l*books[r]+(cnt-1)*(-1))*cnt/2; // Sum of first n elements in AP (n/2)*(2a+(n-1)*d);
    }
}
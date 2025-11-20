class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]!=b[0]?a[0]-b[0]:b[1]-a[1]);
        int n = intervals.length;
        int[] todo = new int[n];
        Arrays.fill(todo,2);
        int ans = 0;

        while(--n>=0){
            int s = intervals[n][0];
            int e = intervals[n][1];
            int m = todo[n];
            for(int p = s;p<s+m;++p){
                for(int i=0;i<=n;++i){
                    if(todo[i]>0&&p<=intervals[i][1]) todo[i]--;
                }
                ans++;
            }
        }
        return ans;
    }
}
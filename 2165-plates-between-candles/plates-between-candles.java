class Solution {
    public int[] platesBetweenCandlesInitialONLogN(String s, int[][] queries) {
        int n = s.length();
        int[] plates = new int[n];
        int curr = 0;
        TreeSet<Integer> ts = new TreeSet<>();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='*') curr++;
            else ts.add(i);
            plates[i]=curr;
        }
        int[] res = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int right = ts.floor(queries[i][1])==null?0:ts.floor(queries[i][1]);
            int left = ts.ceiling(queries[i][0])==null?0:ts.ceiling(queries[i][0]);
            if(right<queries[i][0]||left>queries[i][1]) continue;
            res[i] = plates[right]-plates[left];
            res[i] = Math.max(0,res[i]);
        }
        return res;
    }

    public int[] platesBetweenCandles(String S, int[][] queries) {
        int n = S.length();
        char[] s = S.toCharArray();
        int[] prefixSum = new int[n];
        prefixSum[0] = (s[0] == '*') ? 1 : 0;
        for(int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + (s[i] == '*' ? 1 : 0);
        }
        int[] nextCandle = new int[n];
        int next = -1;
        for(int i = n - 1; i >= 0; i--) {
            if(s[i] == '|') {
                next = i;
            }
            nextCandle[i] = next;
        }
        int[] prevCandle = new int[n];
        int prev = -1;
        for(int i = 0; i < n; i++) {
            if(s[i] == '|') {
                prev = i;
            }
            prevCandle[i] = prev;
        }
        int[] res = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            int x = queries[i][0];
            int y = queries[i][1];
            int leftCandle = nextCandle[x];
            int rightCandle = prevCandle[y];
            if(leftCandle == -1 || rightCandle == -1 || leftCandle >= rightCandle) continue;
            res[i] = prefixSum[rightCandle] - prefixSum[leftCandle];
        }
        return res;
    }
    // public int getPlatesCount(int start, int end, String s){
    //     int count =0;
    //     for(int i=start;i<=Math.min(end,s.length()-1);i++){
    //         if(s.charAt(i)=='*') count++;
    //     }
    //     return count;
    // }
}
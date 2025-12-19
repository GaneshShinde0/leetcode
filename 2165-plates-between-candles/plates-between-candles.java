class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
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
    public int getPlatesCount(int start, int end, String s){
        int count =0;
        for(int i=start;i<=Math.min(end,s.length()-1);i++){
            if(s.charAt(i)=='*') count++;
        }
        return count;
    }
}
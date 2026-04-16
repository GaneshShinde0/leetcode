class Solution {
    public List<Integer> solveQueriesInitial(int[] nums, int[] queries) {
        int n = nums.length;
        HashMap<Integer, TreeSet<Integer>> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.computeIfAbsent(nums[i],v->new TreeSet<Integer>()).add(i);
        }
        int k = queries.length;
        List<Integer> res = new ArrayList<Integer>();
        for(int i=0;i<k;i++){
            int pos = queries[i];
            int curr = nums[queries[i]];
            TreeSet<Integer> ts = hm.get(curr);
            if(ts.size()<2){
                res.add(-1);
                continue;
            }
            Integer right = ts.ceiling(pos+1);
            Integer left = ts.floor(pos-1);
            Integer first = ts.first();
            Integer last = ts.last();
            int shortest = Integer.MAX_VALUE;
            if(right != null) shortest = Math.min(shortest, right-pos);
            if(left !=null) shortest = Math.min(shortest, pos-left);
            if(first!=pos && right == null) shortest = Math.min(shortest, n-pos+first);
            if(last!=pos && left == null) shortest = Math.min(shortest, pos+n-last);
            res.add(shortest);
        }
        return res;
    }

    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        HashMap<Integer, TreeSet<Integer>> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.computeIfAbsent(nums[i],v->new TreeSet<Integer>()).add(i);
        }
        int k = queries.length;
        List<Integer> res = new ArrayList<Integer>();
        for(int i=0;i<k;i++){
            int pos = queries[i];
            int curr = nums[queries[i]];
            TreeSet<Integer> ts = hm.get(curr);
            if(ts.size()<2){
                res.add(-1);
                continue;
            }
            Integer next = ts.higher(pos);
            if (next == null) next = ts.first();

            Integer prev = ts.lower(pos);
            if (prev == null) prev = ts.last();

            int distNext = (next > pos) ? (next - pos) : (n - pos + next);
            int distPrev = (prev < pos) ? (pos - prev) : (pos + n - prev);

            res.add(Math.min(distNext, distPrev));
        }
        return res;
    }
}
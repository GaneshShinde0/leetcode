/*
Approach 1: Segment Tree
This question is essentially asking whether there exists a blank interval of length at least sz that is completely contained within the range [0,x].

To help maintain these blank intervals, we define p[i] as the position of the nearest obstacle to the left of i. The d[i] = i-p[i] represents the length of the maximum blank interval ending at position i.

For each query with parametters x and sz, the problem becomes determining whether there exists an index i<=x such that d[i]>=sz. In other words, we need to check whether the maximum value of d[i] in the interval [0,x] is atleast sz.

We do not need to maintain every individual point. Instead, we only need to maintian the length of the intervals. The next question is where to store these interval lengths so that queries can be processed efficiently.

Observe that each query consists of several complete intervals and at most one incomplete interval truncated by x. We can store the length of each interval at its right endpoint. Specifically, we store d[r] at the right endpoint r, where for every complete interval d[r] equals the distance to the nearest obstacle on the left.

The remaining problem is how to maintain the d array dynamically. We can use a segment tree to support point updates and range maximum queries.

Let pre and nxt denote the positions of the nearest obstacles to the left and right of x, respectively. When inserting an obstacle at position x, we need to update both d[x] is handled separately by comparing its length with sz.

We also need to efficiently determine the nearest obstacle on boht sides of x, which requires maintianing an ordered structure during insertions. A balanced binary search tree can be used for this purpose.
*/
class SolutionSegmentTree {
    private int[] seg;
    private void update(int idx, int val, int p, int l, int r){
        if(l==r){
            seg[p]=val;
            return;
        }
        int mid = (l+r)/2;
        if(idx<=mid){
            update(idx, val,p*2, l, mid);
        }else{
            update(idx, val,(p*2)|1,mid+1, r);
        }
        seg[p] = Math.max(seg[p*2], seg[(p*2)|1]);
    }

    private int query(int L, int R, int p, int l, int r){
        if(L<=l && r<=R) return seg[p];
        int mid = (l+r)>>1;
        int res = 0;
        if(L<=mid){
            res = Math.max(res, query(L,R, p<<1, l, mid));
        }
        if(R>mid){
            res = Math.max(res, query(L,R, (p<<1)|1, mid+1, r));
        }
        return res;
    }
    public List<Boolean> getResults(int[][] queries) {
        int max = 50000;
        seg = new int[max<<2];
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        set.add(max);
        update(max, max, 1, 0, max);
        List<Boolean> ans = new ArrayList<>();

        for(int[] q:queries){
            if(q[0]==1){
                int x = q[1];
                int r = Optional.ofNullable(set.ceiling(x+1)).orElse(max);
                int l = Optional.ofNullable(set.floor(x-1)).orElse(0);
                update(x,x-l,1,0,max);
                update(r,r-x,1,0,max);
                set.add(x);
            }else{
                int x = q[1];
                int size = q[2];
                int pre = Optional.ofNullable(set.floor(x)).orElse(0);
                int maxSpace = query(0,pre, 1, 0, max);
                maxSpace = Math.max(maxSpace, x-pre);
                ans.add(maxSpace>=size);
            }
        }
        return ans;
    }
}

/*
Complexity Analysis:
Let q be the length of queries, and let M be the maximum value of x.
- Time Complexity: O(QlogQ+QlogM).
    Each balanced tree operation requires O(logQ) time, and each segment tree update or query requires O(logM) time.
- Space Complexity: O(M+Q)
    The segment tree requires O(M) space, while the balanced tree store at most O(q) obstacles.
*/

/*
Fenwick Tree

Similar to Segment tree, a Fenwick Tree can also be used to maintain interval maximums. However, after adding an obstacle, interval lengths may decrease, and a Fenwick tree cannot efficiently support such range updates. Therefore, we need a different perspective.

Instead of processing the queries forward, we process them in a reverse order. Initially, we assume that all obstacles already exist. Then, while traversing the queries backward, we remove obstacles one by one, causing adjaccent intervals to merge into larger intervals. 

Let d[r] denote the distance from r to the nearest obstacles on its left, Let pre and nxt represent the positions of the nearest obstacles to the left and right of x, respectively. Then

d[r] = r - pre

When deleting an obstacle position x, the two original intervals [pre,x] and [x,nxt] merge into a single interval [pre,nxt] whose length becomes nxt-pre

Since interval lengths only increase during this reverse process, we can use a Fenwick tree to maintain prefix maximums efficiently.

*/

class Solution{
    private int[] bt;
    private void update(int x,int y){
        for(;x<bt.length; x+=x &-x){ // x &-x gives lowest set bit
            bt[x] = Math.max(bt[x],y);
        }
    }

    private int query(int x){
        int res = 0;
        for(;x>0;x-=x&-x){
            res = Math.max(res, bt[x]);
        }
        return res;
    }

    public List<Boolean> getResults(int[][] queries){
        int max = 50000;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        set.add(max);
        for(int[] q:queries){
            if(q[0]==1) set.add(q[1]);
        }
        bt = new int[max+1];
        int pre = 0;
        for(int x:set){
            if(x==0) continue;
            update(x,x-pre);
            pre = x;
        }
        List<Boolean> ans = new ArrayList<>();
        for(int i=queries.length-1;i>=0;i--){
            int[] q = queries[i];
            if(q[0]==2){
                int x = q[1];
                int size = q[2];
                int preVal = Optional.ofNullable(set.floor(x)).orElse(0);
                int maxSpace = query(preVal);
                maxSpace = Math.max(maxSpace, x-preVal);
                ans.add(maxSpace>=size);
            }else{
                int x = q[1];
                int prevVal = Optional.ofNullable(set.lower(x)).orElse(0);
                int nxt = Optional.ofNullable(set.higher(x)).orElse(max);
                update(nxt, nxt-prevVal);
                set.remove(x);
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}
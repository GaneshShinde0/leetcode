/*
nums1[i]-nums2[i]<=nums1[j]-nums2[j]+diff
*/

class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        int n = nums1.length;
        int[] arr = new int[n];
        Fenwick fw = new Fenwick(60000);
        long res = 0;
        for(int ptr=0;ptr<n;ptr++){
            int val = nums1[ptr]-nums2[ptr]+25000;//offset
            res += fw.query(val+diff);
            fw.update(val,1);
        }
        return res;
    }
}
class Fenwick{
    int n;
    int[] tree;
    public Fenwick(int n){
        this.n=n;
        this.tree = new int[n+1];
    }

    // Update Method: Add delta to index idx
    void update(int idx, int delta){
        // To Update, we move up the tree by adding the lowest set bit.
        while(idx<=n){
            tree[idx] += delta;
            idx += (idx&-idx);
        }
    }
    
    // Query Method: Get prefix sum from 1 to 'idx'
    int query(int idx){
        int sum = 0;
        // To Query, we move down the tree by subtracting the lowest set bit.
        while(idx>0){
            sum+=tree[idx];
            idx -=(idx&-idx);
        }
        return sum;
    }
}
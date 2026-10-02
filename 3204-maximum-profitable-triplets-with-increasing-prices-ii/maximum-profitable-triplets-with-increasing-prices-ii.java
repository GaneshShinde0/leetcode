class Solution {
    public int maxProfit(int[] prices, int[] profits) {
        int min = 5000, max = 0;
        for (int i : prices) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }
        min--;
        max++;
        int[] arr = new int[prices.length];
        Node root1 = new Node(-1, min, max), root2 = new Node(-1, min, max);
        for (int i = 0; i < prices.length; i++) {
            int q1 = root1.query(min, prices[i] - 1);
            root1.update(prices[i], profits[i]);
            if (q1 != -1 && arr[i] != -1) {
                arr[i] += q1;
            } else if (q1 == -1) {
                arr[i] = -1; 
            }
            int j = prices.length - 1 - i;
            int q2 = root2.query(prices[j] + 1, max);
            root2.update(prices[j], profits[j]);
            if (q2 != -1 && arr[j] != -1) {
                arr[j] += q2;
            } else if (q2 == -1) {
                arr[j] = -1; 
            }
        }
        int res = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != -1) {
                int tmp = arr[i] + profits[i];
                if (tmp > res) {
                    res = tmp;
                }
            }
        }
        return res;
    }
}

class Node {
    int val;
    int lo;
    int hi;
    int mid;
    Node l, r;
    
    Node(int v, int l, int r) {
        val = v;
        lo = l;
        hi = r;
        mid = lo + (hi - lo) / 2;
    }
    
    void update(int arrIx, int val) {
        if (lo == hi) {
            this.val = Math.max(val, this.val);
            return;
        }
        if (arrIx > mid) {
            if (r == null) {
                r = new Node(-1, mid + 1, hi);
            }
            r.update(arrIx, val);
        } else {
            if (l == null) {
                l = new Node(-1, lo, mid);
            }
            l.update(arrIx, val);
        }
        if (l == null) {
            this.val = r.val;
            return;
        }
        if (r == null) {
            this.val = l.val;
            return;
        }
        this.val = Math.max(l.val, r.val);
    }
    
    int query(long i, long j) {
        if (lo > j || hi < i) {
            return 0;
        }

        if (i <= lo && j >= hi) {
            return val;
        }

        if (i > mid) {
            if (r == null) {
                return -1;
            }
            return r.query(i, j);
        } else if (j <= mid) {
            if (l == null) {
                return -1;
            }
            return l.query(i, j);
        }
        if (r == null && l == null) {
            return val;
        }
        if (r == null) {
            return l.query(i, j);
        }
        if (l == null) {
            return r.query(i, j);
        }
        return Math.max(r.query(i, j), l.query(i, j));
    }
}
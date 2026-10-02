class Solution {
    public int[] findMaximums(int[] n) {
        int[] res = new int[n.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i <= n.length; ++i) {
            while (!s.empty() && (i == n.length || n[s.peek()] >= n[i])) {
                int j = s.pop(), k = i - 1;
                if (!s.empty())
                    k -= s.peek() + 1;
                res[k] = Math.max(res[k], n[j]);
            }
            s.push(i);
        }    
        for (int i = res.length - 1; i > 0; --i)
            res[i - 1] = Math.max(res[i - 1], res[i]);    
        return res;
    }
}
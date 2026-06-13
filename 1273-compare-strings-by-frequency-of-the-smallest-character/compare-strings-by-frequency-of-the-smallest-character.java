class Solution {
        public int[] numSmallerByFrequency(String[] queries, String[] words) {
        //create arrays to save func for each query and word
        int[] q = new int[queries.length];
        int[] w = new int[words.length];
        //fill q and w for each array member
        for (int i = 0; i < q.length; i++) {
            q[i] = getFunc(queries[i]);
        }
        for (int i = 0; i < w.length; i++) {
            w[i] = getFunc(words[i]);
        }
        Arrays.sort(w);
        int[] res = new int[q.length];
        for (int i = 0; i < q.length; i++) {
            int l = 0, r = w.length - 1;
            while (l <= r) {
                int m = (r + l) / 2;
                if (w[m] <= q[i]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            res[i] = w.length - l;
        }
        return res;
    }
    
    int getFunc(String s) {
        char chr = 'z';
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch < chr) {
                count = 1;
                chr = ch;
            } else if (chr == ch) {
                count++;
            }
        }
        return count;
    }
}
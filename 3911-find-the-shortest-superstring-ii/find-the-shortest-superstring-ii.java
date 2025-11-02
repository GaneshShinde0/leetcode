class Solution {
    // time = O(n^2), space = O(n)
    public String shortestSuperstring(String s1, String s2) {
        int m = s1.length(), n = s2.length(), k = Math.min(m, n);
        if (m >= n && s1.contains(s2) || m < n && s2.contains(s1)) return m >= n ? s1 : s2;
        for (int i = k; i > 0; i--) {
            if (s1.substring(0, i).equals(s2.substring(n - i))) return s2 + s1.substring(i);
            if (s2.substring(0, i).equals(s1.substring(m - i))) return s1 + s2.substring(i);
        }
        return s1 + s2;
    }
}
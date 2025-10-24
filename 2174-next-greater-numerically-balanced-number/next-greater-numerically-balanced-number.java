import java.util.*;

class Solution {
    private static final List<Integer> beautiful = new ArrayList<>();

    static {
        for (int i = 1; i <= 1224444; i++) {
            if (isBalance(i)) beautiful.add(i);
        }
    }

    private static boolean isBalance(int x) {
        int[] count = new int[10];
        while (x > 0) {
            count[x % 10]++;
            x /= 10;
        }
        for (int d = 0; d < 10; ++d) {
            if (count[d] > 0 && count[d] != d) return false;
        }
        return true;
    }

    public int nextBeautifulNumber(int n) {
        int idx = Collections.binarySearch(beautiful, n + 1);
        if (idx < 0) idx = -idx - 1; // insertion point
        return idx < beautiful.size() ? beautiful.get(idx) : -1;
    }
}

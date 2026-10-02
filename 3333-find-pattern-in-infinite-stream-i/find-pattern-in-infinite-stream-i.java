class Solution {
    public int findPattern(InfiniteStream infiniteStream, int[] pattern) {
        int hashp = 0;
        for (int i = 0; i < pattern.length; i++) {
            hashp = hashp * 2 + pattern[i];
        }
        int hashs = 0;
        for (int i = 0; i < pattern.length; i++) {
            hashs = hashs * 2 + infiniteStream.next();
        }

        int idx = 0;
        int base = (int)Math.pow(2, pattern.length - 1);
        while (true) {
            if (hashs == hashp) {
                return idx;
            }
            hashs -= (hashs / base) * base;
            hashs = hashs * 2 + infiniteStream.next();
            idx++;
        }
    }
}
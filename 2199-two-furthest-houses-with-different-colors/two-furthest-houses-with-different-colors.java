class Solution {
    public int maxDistance(int[] colors) {
        int start = 0, n = colors.length, end = n-1;
        while(colors[start]==colors[n-1]) start++;
        while(colors[end]==colors[0]) end--;
        return Math.max(end,n-start-1);
    }
}
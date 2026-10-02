class Solution {
    public int meetRequirement(int n, int[][] lights, int[] requirement) {
        int count = 0;
        int[] cover = new int[n];
        int[] diff = new int[n];
        for(int[] light : lights){
            int left = Math.max(0, light[0] - light[1]);
            int right = Math.min(n - 1, light[0] + light[1]);
            diff[left]++;
            if(right + 1 < n){
                diff[right + 1]--;
            }
        }
        cover[0] = diff[0];
        for(int i = 1; i < n; i++){
            cover[i] = cover[i - 1] + diff[i];
        }
        for(int i = 0; i < n; i++){
            if(cover[i] >= requirement[i]){
                count++;
            }
        }
        return count;
    }
}
class Solution {
    public int minimumLevels(int[] possible) {
        int n = possible.length;
        
        int[] prefix = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++){
            if (possible[i] == 0) sum = sum - 1;
            else sum = sum + 1;
            
            prefix[i] = sum;
        }
        for (int i = 0; i < n-1; i++){
            if (prefix[i] > sum - prefix[i]) return i+1;
        }
        return -1;
        
    }
}
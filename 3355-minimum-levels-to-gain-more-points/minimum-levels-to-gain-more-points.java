class Solution {
    public int minimumLevelsInitial(int[] possible) {
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
    public int minimumLevels(int[] possible) {
        int n = possible.length;
        
        int sum = 0;
        for (int i = 0; i < n; i++){
            if (possible[i] == 0) sum = sum - 1;
            else sum = sum + 1;
        }
        int rightSum = 0;
        int res = -1;
        for (int i = 0; i < n-1; i++){
            rightSum = rightSum +((possible[i] == 0)?- 1:1);
            if (sum-rightSum <rightSum) return i+1;
        }
        return res;
        
    }

}
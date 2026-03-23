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
        
        int totalPoints = 0;
        for (int i = 0; i < n; i++){
            if (possible[i] == 0) totalPoints = totalPoints - 1;
            else totalPoints = totalPoints + 1;
        }
        int alicesCurrentPoints = 0;
        for (int i = 0; i < n-1; i++){
            alicesCurrentPoints = alicesCurrentPoints +((possible[i] == 0)?- 1:1);
            if (alicesCurrentPoints > totalPoints-alicesCurrentPoints) return i+1; //
        }
        return -1;
        
    }

}
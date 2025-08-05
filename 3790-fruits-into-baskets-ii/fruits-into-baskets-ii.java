class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int unplaced = 0;
        int n = fruits.length;
        boolean[] used = new boolean[n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n;j++){
                if(!used[j]&&fruits[i]<=baskets[j]){
                    used[j]=true;
                    break;
                }
            }
        }
        for(int i=0;i<n;i++){
            if(!used[i]) unplaced++;
        }
        return unplaced;
    }
}
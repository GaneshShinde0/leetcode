class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            res[i]=getCountOfPotionsGreaterThanSuccess(spells[i],success,potions);
        }
        return res;
    }

    private int getCountOfPotionsGreaterThanSuccess(int spell,long success, int[] potions){
        int left = 0, n = potions.length,right=n;
        // left = 0, right = 5, mid = 2, potions[mid] = 3
        // 3*3>potions[mid]
        // right = 1; mid = 0
        while(left<right){
            int mid = (right+left)/2;
            if(((long)potions[mid]*spell)<success){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return n-right;
    }

}
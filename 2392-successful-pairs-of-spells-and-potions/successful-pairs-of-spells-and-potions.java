class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = potions.length;
        int[] res = new int[spells.length];
        for(int i=0;i<spells.length;i++){
            res[i] = n-binarySearch(potions,spells[i],success);
        }
        return res;
    }

    private int binarySearch(int[] potions, long mult, long success){
        int left = 0, right = potions.length;
        while(left<right){
            int mid = (right-left)/2+left;
            if(potions[mid]*mult<success){
                left = mid+1;
            }else{
                right = mid;
            }
            // System.out.println("Left: "+left+"Right: "+right+" Mid: "+mid);
        }
        return left;
    }
}
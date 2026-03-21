class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int emptyBeds = 1;
        int canPlace = 0;
        for(int i=0;i<len;i++){
            if(flowerbed[i]==1){
                canPlace += (emptyBeds-1)/2;
                emptyBeds = 0;
                if(canPlace>=n) return true;
            }else emptyBeds++;
        }

        if(emptyBeds>=2) canPlace+=emptyBeds/2;
        return canPlace>=n;
    }
}
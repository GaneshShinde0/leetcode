class Solution {
    public boolean canPlaceFlowers(int[] flowerBed, int n) {
        int emptyBeds = 1, canPlace = 0;
        for(int i=0;i<flowerBed.length;i++){
            if(flowerBed[i]==1){
                canPlace += (emptyBeds-1)/2;
                emptyBeds = 0;
            }else emptyBeds++;
        }
        if(emptyBeds>=2) canPlace+=emptyBeds/2;
        return canPlace>=n;
    }
}
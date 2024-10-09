class CanPlaceFlowers {
    // Takes 1 ms
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count=0;
        if (flowerbed.length==1 && flowerbed[0]==0 && (n==1||n==0)) return true;
        if(flowerbed[0]==0 && flowerbed[1]==0) {
            count++;
            flowerbed[0]=1;
        };
        if(flowerbed[flowerbed.length-1]==0 && flowerbed[flowerbed.length-2]==0) {
            count++;
            flowerbed[flowerbed.length-1]=1;
        };
        for(int i=1; i<flowerbed.length-1;i++){
            if(flowerbed[i]==0 && flowerbed[i-1]==0 && flowerbed[i+1]==0){
                count++;
                i++;
            }
        }
        return count>=n;
    }

    public boolean canPlaceFlowers0ms(int[] flowerbed, int n) {
        if(n == 0){
            return true;
        }

        for(int i=0; i<flowerbed.length; i+=2){
            if(flowerbed[i] == 0){
                if(i == flowerbed.length-1 || flowerbed[i+1] == 0){
                    n--;
                    if(n == 0){
                        return true;
                    }
                }else{
                    i++;
                }
            }
        }
        return n <= 0;
    }
}

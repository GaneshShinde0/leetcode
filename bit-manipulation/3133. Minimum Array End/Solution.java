class Solution {
    public long minEndTLE(int n, int x) {
        int curr=x;
        int i=0;
        int res =x;
        while(i<n){
            if((curr & x)==x){
                i++;
            }
            curr++;
        }
        return curr-1;
    }

    public long minEnd2Second(int n, int x) {
        long result = x;

        // Step 1: Iterate n-1 times (since we already initialized result with x)
        while (--n > 0) {
            // Step 2: Increment result and perform bitwise OR with x
            result = (result + 1) | x;
        }

        return result;
    }

    public long minEndWithLogicalOperation(int n, int x){
        long result = x;
        long mask;
        n--;

        for(mask = 1;n>0;mask<<=1){
            if((mask&x)==0){
                result |=(n&1)*mask;
                n>>=1;
            }
        }
        return result;
    }

    public long minEnd(int n, int x){
        long result = 0, bit;
        // Reducing n by 1 to exclude x from the iteration
        --n;

        int[] binaryX = new int[64];
        int[] binaryN = new int[64];

        long longX = x;
        long longN = n;
        
        for(int i=0; i<64; ++i){
            bit = (longX>>i)&1; // Extract ith bit of x
            binaryX[i]=(int) bit;

            bit = (longN>>i)&1;
            binaryN[i] = (int) bit;
        }

        int posX = 0, posN = 0;

        while(posX<64){
            while(binaryX[posX] != 0 && posX<64){
                ++posX;
            }

            binaryX[posX] = binaryN[posN];
            ++posX;
            ++posN;
        }

        for(int i=0; i<64; ++i){
            if(binaryX[i]==1){
                result+=Math.pow(2,i);
            }
        }
        return result;
    }
}

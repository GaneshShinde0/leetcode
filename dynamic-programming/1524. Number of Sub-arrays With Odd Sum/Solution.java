class Solution {
    public int numOfSubarraysTLE(int[] arr) {
        final int MOD = (int) (1e9+7);
        int n = arr.length, count=0;
        // Generate all possible subarrays
        for(int i=0;i<n;i++){
            int currSum = 0;
            for (int j=i;j<n;j++){
                currSum+=arr[j];
                if(currSum%2==1) count++;
            }
        }
        return count%MOD;
    }

    public int numOfSubarraysDP(int[] arr) {
        int MOD = (int) Math.pow(10,9)+7;
        int n = arr.length;
        for(int i=0;i<n;i++) arr[i]=arr[i]%2;
        int[] dpEven = new int[n], dpOdd = new int[n];
        // Initialization based on the last element, The last element is even
        if(arr[n-1]==0) dpEven[n-1]=1;
        else dpOdd[n-1]=1;
        for(int i=n-2;i>=0;i--){
            if(arr[i]==1){
                dpOdd[i]=(1+dpEven[i+1])%MOD;
                dpEven[i]=dpOdd[i+1];
            }else{
                dpEven[i] = (1+dpEven[i+1])%MOD;
                dpOdd[i]=dpOdd[i+1];
            }
        }
        int count=0;
        for(int oddCount:dpOdd){
            count+=oddCount;
            count%=MOD;
        }
        return count;
    }
    //Using Prefix Sum
    public int numOfSubarrays(int[] arr){
        final int MOD = 1_000_000_007;
        int count = 0, pSum = 0;
        int oddCount = 0, evenCount = 1;
        for(int i:arr){
            pSum +=i;
            if(pSum%2==0){
                count+=oddCount;
                evenCount++;
            }else{
                count+=evenCount;
                oddCount++;
            }
            count%=MOD;
        }
        return count;
    }
}

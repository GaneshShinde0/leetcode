class Solution {
    private static final int MOD = 1000000007;
    public int[] productQueriesUsingLI(int n, int[][] queries) {
        List<Long> li = new ArrayList<>();
        long curr = 1;
        while(n>0){
            if(n%2==1) li.add(curr);
            curr*=2;
            n/=2;
        }
        int size = li.size();
        long[][] temp = new long[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                temp[i][j] = 1;
                for(int k=i;k<=j;k++){
                    temp[i][j]= (temp[i][j]*li.get(k))%MOD;
                }
            }
            // System.out.println(Arrays.toString(temp[i]));
        }

        int[] res = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            res[i]=(int) temp[queries[i][0]][queries[i][1]]%MOD;
        }
        return res;
    }

    public int[] productQueries(int n, int[][] queries) {
        int count = Integer.bitCount(n);
        long[] arr = new long[count];
        long curr = 1;
        int index = 0;

        while (n > 0) {
            if ((n & 1) == 1) {
                arr[index++] = curr;
            }
            curr *= 2;
            n >>= 1;
        }

        int size = arr.length;
        long[][] temp = new long[size][size];
        
        for (int i = 0; i < size; i++) {
            temp[i][i] = arr[i] % MOD; // Initialize diagonal
            for (int j = i + 1; j < size; j++) {
                temp[i][j] = (temp[i][j - 1] * arr[j]) % MOD;
            }
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            res[i] = (int)(temp[l][r] % MOD);
        }

        return res;
    }
}
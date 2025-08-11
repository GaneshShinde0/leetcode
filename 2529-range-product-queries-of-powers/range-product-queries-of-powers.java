class Solution {
    private static final int MOD = 1000000007;
    public int[] productQueries(int n, int[][] queries) {
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
}
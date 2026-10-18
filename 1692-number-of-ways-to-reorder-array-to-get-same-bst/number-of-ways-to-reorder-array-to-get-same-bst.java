class Solution {
    private int MOD = 1_000_000_007;
    private long[][] table;
    public int numOfWays(int[] nums) {
        int n = nums.length;
        table = new long[n][n];
        for(int i=0;i<n;i++){
            table[i][0]=table[i][i] = 1;
        }
        for(int i=2;i<n;i++){
            for(int j=1;j<i;j++){
                table[i][j] = (table[i-1][j-1]+table[i-1][j])%MOD;
            }
        }
        List<Integer> arrList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        return (int) ((dfs(arrList)-1)%MOD);
    }
    private long dfs(List<Integer> nums){
        int n = nums.size();
        if(n<3) return 1;
        List<Integer> leftNodes = new ArrayList<>();
        List<Integer> rightNodes = new ArrayList<>();
        for(int i=1;i<n;i++){
            if(nums.get(i)<nums.get(0)){
                leftNodes.add(nums.get(i));
            }else{
                rightNodes.add(nums.get(i));
            }
        }
        long leftWays = dfs(leftNodes)%MOD;
        long rightWays = dfs(rightNodes)%MOD;

        return (((leftWays*rightWays)%MOD)*table[n-1][leftNodes.size()])%MOD;
    }
}
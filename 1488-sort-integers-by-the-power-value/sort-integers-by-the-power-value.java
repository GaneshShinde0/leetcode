class Solution {
    private int[] memo = new int[3001];
    public int getKth(int lo, int hi, int k) {
        int n = hi-lo+1;
        int[][] powArr = new int[n][2];
        for(int i=lo;i<=hi;i++){
            powArr[i-lo][0]=i;
            if(memo[i]>0){
                powArr[i-lo][1]= memo[i];
            }else{
                memo[i]=calculatePower(i);
                powArr[i-lo][1] = memo[i];
            }
        }
        Arrays.sort(powArr,(a,b)->{
            if(a[1]==b[1]){
                return Integer.compare(a[0],b[0]);
            }
            return Integer.compare(a[1],b[1]);
        });
        return powArr[k-1][0];
    }

    private int calculatePower(int x){
        int pow = 1;
        while(x!=1){
            if(x%2==0)x/=2;
            else x=3*x+1;
            pow++;
        }
        return pow;
    }
}
class Solution {
    public int[] circularGameLosers(int n, int k) {
        boolean[] isLoser = new boolean[n];
        int i=0;
        int mult = 1;
        while(!isLoser[i]){
            isLoser[i]=true;
            i = (i+mult*k)%n;
            mult++;
        }
        int[] res = new int[n-mult+1];
        int j=0;
        for(i=0;i<n;i++){
            if(!isLoser[i]){
                res[j]=i+1;
                j++;
            }
        }
        return res;
    }
}
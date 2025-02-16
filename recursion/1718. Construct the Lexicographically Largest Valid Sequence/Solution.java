class Solution {
    public int[] constructDistancedSequence(int n) {
        int[] res = new int[2*n-1];
        boolean[] used = new boolean[n+1];
        findLexicographicallyLargestSequence(0, res,used,n);
        return res;
    }

    private boolean findLexicographicallyLargestSequence(int i,int[] res,boolean[] used,int n){
        if(i==res.length) return true;
        if(res[i]!=0){
            return findLexicographicallyLargestSequence(i+1, res, used, n);
        }
        for(int j=n;j>=1;j--){
            if(used[j]) continue;
            used[j]=true;
            res[i]=j;
            if(j==1){
                if(findLexicographicallyLargestSequence(i+1,res,used, n)) return true;
            }else if(i+j<res.length && res[i+j]==0){
                res[i+j]=j;
                if(findLexicographicallyLargestSequence(i+1,res,used,n)) return true;
                res[i+j]=0;
            }
            res[i]=0;
            used[j]=false;
        }
        return false;
    }
}

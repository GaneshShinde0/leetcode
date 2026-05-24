class Solution {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int[] mJ = new int[n];
        int res = 0;
        for(int i=0;i<n;i++){
            res = Math.max(dfs(arr,mJ,i,d),res);
        }
        return res;
    }
    private int dfs(int[] arr,int[] mJ, int i, int d){
        if(mJ[i]!=0) return mJ[i];
        int maxJumpsFromI = 1;
        int start = Math.max(i-d,0);
        int end = Math.min(i+d,arr.length-1);
        for(int j=i-1;j>=start;j--){
            if(arr[i]>arr[j]){
                mJ[i]+=1;
                maxJumpsFromI=Math.max(maxJumpsFromI, dfs(arr,mJ,j,d)+1);            
            }else{
                break;
            }
        }
        for(int j=i+1;j<=end;j++){
            if(arr[i]>arr[j]){
                mJ[i]+=1;
                maxJumpsFromI=Math.max(maxJumpsFromI, dfs(arr,mJ,j,d)+1);
            }else{
                break;
            }
        }
        mJ[i] = maxJumpsFromI;
        return maxJumpsFromI;
    }
}
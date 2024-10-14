class Solution {
    //130 ms
    public int[] minOperationsInitialSolution(String boxes) {
        int len = boxes.length();
        int[] res = new int[len];
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(i!=j && boxes.charAt(j)=='1') res[i]+= Math.abs(i-j);
            }
        }
        return res;
    }

    // 29 ms
    public int[] minOperationsOptimized(String boxes) {
        int len = boxes.length();
        int[] res = new int[len];
        for(int i=0;i<len;i++){
            if(boxes.charAt(i)=='1'){
            for(int j=0;j<len;j++){
                if(i!=j) res[j]+= Math.abs(i-j);
            }
            }
        }
        return res;
    }

    // 3ms
    public int[] minOperations(String boxes) {
      char[] box=boxes.toCharArray();
      int n=box.length,prefix=0,suffix=0;
      int[] prefixSums=new int[n];
      int[] suffixSums=new int[n];

      int ones=0,dist=0;
      for(int i=0;i<n;i++){
        prefixSums[i]=dist;
        if(box[i]=='1')ones++;
        dist+=ones;
      }
      ones=0;dist=0;
      for(int i=n-1;i>=0;i--){
        suffixSums[i]=dist;
        if(box[i]=='1')ones++;
        dist+=ones;
      }
      
      int[] ans=new int[n];  
      for(int i=0;i<n;i++)ans[i]=prefixSums[i]+suffixSums[i];
      return ans;
    }
}

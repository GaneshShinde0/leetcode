class Solution {
    public int minimumBuckets(String hamsters) {
        int res = 0;
        int n = hamsters.length();
        char[] arr = hamsters.toCharArray();
        for(int i=0;i<n;i++){
            int prev = Math.max(0,i-1);
            int next = Math.min(n-1,i+1);
            if(arr[i]!='H') continue;
            else if(arr[i]=='H' && arr[prev]=='H' && arr[next]=='H') return -1;
            else if(arr[next]=='.'&&arr[prev]!='D'){
                arr[next]='D';
                res++;
            }else if(arr[next]=='H' && arr[prev]=='.'){
                arr[prev]='D';
                res++;
            }
        }
        return res;
    }
}
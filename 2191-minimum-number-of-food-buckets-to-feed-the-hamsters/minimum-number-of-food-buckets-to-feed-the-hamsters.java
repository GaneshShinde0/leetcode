class Solution {
    public int minimumBuckets(String hamsters) {
        int n = hamsters.length();
        int buckets = 0;
        int lastBucketPos = -2; // Tracks the position of the last placed bucket

        for (int i = 0; i < n; i++) {
            if (hamsters.charAt(i) == 'H') {
                if (lastBucketPos == i - 1) {
                    continue;
                }

                // 2. Greedy choice: Try placing a bucket at i+1
                if (i + 1 < n && hamsters.charAt(i + 1) == '.') {
                    buckets++;
                    lastBucketPos = i + 1; // Mark bucket position
                } 
                // 3. Forced choice: Try placing a bucket at i-1
                else if (i - 1 >= 0 && hamsters.charAt(i - 1) == '.') {
                    buckets++;
                    lastBucketPos = i - 1; // Mark bucket position
                } 
                // 4. Impossible case
                else {
                    return -1;
                }
            }
        }
        return buckets;
    }
    public int minimumBucketsInitial(String hamsters) {
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
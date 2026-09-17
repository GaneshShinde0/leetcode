class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length, sum = 0, res = Integer.MAX_VALUE, minLen=n;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0,-1);
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(hm.containsKey(sum-target)){
                int prev = hm.get(sum-target);
                res = Math.min(res, i-prev+(prev==-1?n:arr[prev]));
                minLen = Math.min(minLen, i-prev);
            }
            arr[i] = minLen;
            hm.put(sum, i);
        }
        return res>n?-1:res;
    }
    public int minSumOfLengthsInitial(int[] arr, int target) {
        int n = arr.length, sum = 0, res = Integer.MAX_VALUE;
        int[] minLengthLeft = new int[n+1];
        Arrays.fill(minLengthLeft, n+1);
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0,-1);
        for(int i=0;i<n;i++){
            sum+=arr[i];
            minLengthLeft[i+1] = minLengthLeft[i];
            if(hm.containsKey(sum-target)){
                minLengthLeft[i+1] = Math.min(i-hm.get(sum-target), minLengthLeft[i]);
            }
            hm.put(sum, i);
        }
        // System.out.println(Arrays.toString(minLengthLeft));
        hm.clear();
        sum = 0;
        hm.put(0,n);
        int minOnRight = arr.length;
        for(int i=n-1;i>=0;i--){
            sum+=arr[i];
            if(hm.containsKey(sum-target)){
                minOnRight = Math.min(hm.get(sum-target)-i, minOnRight);
                res = Math.min(res, minLengthLeft[i]+minOnRight);
            }
            hm.put(sum, i);
        }
        return res>n?-1:res;
    }
}
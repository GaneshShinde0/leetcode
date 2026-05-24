class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b)->{
            if(a[0]==b[0]) return Integer.compare(a[1],b[1]);
            else return Integer.compare(b[0],a[0]);
        });
        List<int[]> li = new ArrayList<>();
        li.add(envelopes[0]);
        for(int i=1;i<envelopes.length;i++){
            int[] prev = li.get(li.size()-1);
            int[] curr = envelopes[i];
            if(prev[0]>curr[0] && prev[1]>curr[1]) li.add(curr);
            else{
                int idx = binarySearch(li,curr);
                li.set(idx,curr);
            }
        }
        return li.size();
    }
    private int binarySearch(List<int[]> li, int[] target){
        int low = 0, high = li.size()-1;
        while(low<high){
            int mid = (low+high)/2;
            if(li.get(mid)[0]>target[0] && li.get(mid)[1]>target[1]){
                low = mid+1;
            }else{
                high = mid;
            }
        }
        return low;
    }
}
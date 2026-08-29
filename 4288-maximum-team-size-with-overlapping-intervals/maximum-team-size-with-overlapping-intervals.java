class Solution {
    public int maximumTeamSize(int[] start, int[] end) {
        int n = start.length;
        int[] sortedStart = start.clone();
        int[] sortedEnd = end.clone();
        Arrays.sort(sortedStart);
        Arrays.sort(sortedEnd);
        int max = 0;
        for(int i=0;i<n;i++){
            int a = upperBound(sortedStart, end[i]); // last start on/before end;
            int b = lowerBound(sortedEnd, start[i]); // last end before start;
            max = Math.max(max, a-b);
        }
        return max;
    }

    private int upperBound(int[] arr, int target){
        int r = arr.length, l = 0;
        while(l<r){
            int m=(l+r)/2;
            if(arr[m]<=target) l = m+1;
            else r=m;
        }
        return l;
    }
    private int lowerBound(int[] arr, int target){
        int r = arr.length, l = 0;
        while(l<r){
            int m=(l+r)/2;
            if(arr[m]<target) l = m+1;
            else r=m;
        }
        return l;
    }
}
class Solution {
    public int hIndexSorting(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int res = 0;
        for(int i=0;i<citations.length;i++){
            if(citations[i]>= n-i){// If this is greater than n-i then next elements will surely be as array is sorted.
                return n-i;
            }
        }
        return 0;
    }
    public int hIndex(int[] citations){
        int n = citations.length;
        int[] papers = new int[n+1];
        // Counting papers for each citation number.
        for(int c:citations){
            papers[Math.min(c,n)]++; // Storing citations for every index.
        }
        int res = n; // Consider result as max initially
        for(int i=papers[n];res>i;i+=papers[res]){ // Start with how many there are at max.
            res--;
        }
        return res;
    }
}
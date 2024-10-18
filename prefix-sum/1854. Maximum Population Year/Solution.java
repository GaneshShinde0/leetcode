class Solution {
    public int maximumPopulationInitialSolution(int[][] logs) {
        int[] freq = new int[101];
        for(int arr[]: logs){
            for(int i=arr[0];i<arr[1];i++){
                freq[i-1950]++;
            }
        }
        // System.out.println(Arrays.toString(freq));
        int max = 0;
        for(int i=0;i<freq.length;i++){
            if(freq[i]>freq[max]) max = i;
        }
        return max+1950;
    }
    public int maximumPopulation(int[][] logs) {
        int[] freq = new int[101];
        for(int arr[]: logs){
            freq[arr[0]-1950]++;
            freq[arr[1]-1950]--;
        }
        int max = 0;
        for(int i=1;i<freq.length;i++){
            freq[i]+=freq[i-1];
            if(freq[i]>freq[max]) max = i;
        }
        return max+1950;
    }
}

class Solution {
    public List<Integer> longestCommonSubsequence(int[][] arrays) {
        int[] freq = new int[101];
        int req = arrays.length;
        List<Integer> res = new ArrayList<>();
        for(int[] arr:arrays){
            for(int i:arr){
                freq[i]++;
            }
        }
        for(int i=0;i<freq.length;i++){
            if(freq[i]==req) res.add(i);
        }
        return res;
    }
}
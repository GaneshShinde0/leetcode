class Solution {
    public int countElements(int[] arr) {
        int[] freq = new int[1001];
        for(int i:arr){
            freq[i]++;
        }
        int res = 0;
        for(int i=0;i<1000;i++){
            if(freq[i]>0 && freq[i+1]>0){
                res+=freq[i];
            }
        }
        return res;
    }
}
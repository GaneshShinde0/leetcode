class Solution {
    public int getLeastFrequentDigit(int n) {
        int[] freq = new int[10];
        int min = n%10;
        while(n>0){
            freq[n%10]++;
            n/=10;
        }
        for(int i=9;i>=0;i--){
            if(freq[i]!=0 && freq[i]<=freq[min]){
                min=i;
            }
        }
        return min;
    }
}
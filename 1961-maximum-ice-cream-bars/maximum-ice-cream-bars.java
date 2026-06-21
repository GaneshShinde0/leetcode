class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int[] freq = new int[100001];
        int res = 0;
        for(int cost:costs){
            freq[cost]++;
        }
        for(int i=0;i<=100000;i++){
            if(coins<i) break;
            while(freq[i]>0 && coins>=i){
                res++;
                coins-=i;
                freq[i]--;
            }
        }
        return res;
    }
}
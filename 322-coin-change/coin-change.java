class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] arr = new int[amount+1];
        Arrays.fill(arr,amount+1);
        arr[0] = 0;
        for(int i=0;i<=amount;i++){
            for(int c: coins){
                if(i-c>=0 && arr[i-c]!=(amount+1)){
                    arr[i] = Math.min(arr[i], arr[i-c]+1);
                }
            }
        }
        if(arr[amount]==amount+1) return -1;
        else return arr[amount];
    }
}
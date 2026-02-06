class Solution {
    public int getWinner(int[] arr, int k) {
        int n = arr.length;
        int count = 0;
        int currentWinner = arr[0];
        for(int i=1;i<arr.length;i++){
            if(currentWinner<arr[i]){
                currentWinner=arr[i];
                count = 1;                
            }else{
                count++;
            }
            if(count==k) return currentWinner;
        }
        int max = 0;
        // for(int i:arr) max = Math.max(max,i);
        return currentWinner;        
   }
}
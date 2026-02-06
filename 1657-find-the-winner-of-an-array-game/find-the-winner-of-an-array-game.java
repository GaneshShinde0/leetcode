class Solution {
    public int getWinner(int[] arr, int k) {
        int n = arr.length;
        int count = 0;
        for(int i=1;i<arr.length;i++){
            if(arr[0]<arr[i]){
                arr[0]=arr[i];
                count = 1;                
            }else{
                count++;
            }
            if(count==k) return arr[0];
        }
        int max = 0;
        for(int i:arr) max = Math.max(max,i);
        return max;        
   }
}
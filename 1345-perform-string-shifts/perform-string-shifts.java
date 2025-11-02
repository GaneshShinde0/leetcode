class Solution {
    public String stringShift(String s, int[][] shift) {
        int n = s.length();
        for(int[] arr:shift){
            arr[1]=arr[1]%n;
            if(arr[0]==1){
                s = s.substring(n-arr[1])+s.substring(0,n-arr[1]);
            }else{
                s = s.substring(arr[1])+s.substring(0,arr[1]);
            }
        }
        return s;
    }
}
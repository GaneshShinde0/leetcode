class Solution {
    public int findMinArrowShots(int[][] arr) {
        Arrays.sort(arr,(a,b)->Integer.compare(a[1],b[1]));
        for(int[] ar:arr){
            System.out.println(Arrays.toString(ar));
        }
        int prev =arr[0][1], res = 1;
        for(int i=1;i<arr.length;i++){
            if(arr[i][0]<=prev){
                continue;
            }else{
                res++;
                prev=arr[i][1];
            }

        }
        return res;
    }
}
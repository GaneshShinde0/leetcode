class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr,(a,b)->{
            if(digitSum(a[0])==digitSum(b[0])) return Integer.compare(a[0],b[0]);
            else return Integer.compare(digitSum(a[0]),digitSum(b[0]));
        });
        boolean[] visited = new boolean[n];
        int cycles = 0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                cycles++;
                int j = i;
                while(!visited[j]){
                    visited[j] = true;
                    j = arr[j][1];
                }
            }
        }
        return n-cycles;
    }
    private int digitSum(int num){
        int sum =0;
        while(num>0){
            int rem = num%10;
            sum+=rem;
            num/=10;
        }
        return sum;
    }
}
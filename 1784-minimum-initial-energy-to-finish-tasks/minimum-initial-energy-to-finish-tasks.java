class Solution {
    public int minimumEffort(int[][] tasks) {
        int min = 0, max = 0;
        Arrays.sort(tasks,(a,b)->Integer.compare(a[1]-a[0],b[1]-b[0]));
        for(int[] t:tasks){
            min += t[0];
            max += t[1];
        }
        int res = max;
        while(min<max){
            int mid = (min+max)/2;
            if(canComplete(tasks,mid)){
                max = mid;
            }else{
                min = mid+1;
            }
        }
        return max;
    }
    private boolean canComplete(int[][] tasks,int time){
        for(int i=tasks.length-1;i>=0;i--){
            if(time-tasks[i][1]<0) return false;
            else time-=tasks[i][0];
        }
        return true;
    }
}
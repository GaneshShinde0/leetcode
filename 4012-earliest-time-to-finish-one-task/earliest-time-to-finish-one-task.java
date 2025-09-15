class Solution {
    public int earliestTime(int[][] tasks) {
        int res = Integer.MAX_VALUE;
        for(int[] task:tasks){
            res = Math.min(res,task[0]+task[1]);
        }
        return res;
    }
}
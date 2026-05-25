class Solution {
    
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        boolean[] dp = new boolean[n];;
        dp[0]=true;
        int reachable = 0;
        for(int i=1;i<n;i++){
            if(i-minJump>=0 && dp[i-minJump]) reachable++;
            if(i-maxJump-1>=0 && dp[i-maxJump-1]) reachable--;
            dp[i] = reachable>0 && s.charAt(i)=='0';
        }
        return dp[n-1];
    }
    public boolean canReachDFS(String s, int minJump, int maxJump) {
        int n = s.length();
        Queue<Integer> queue = new LinkedList<>();
        char[] arr = s.toCharArray();
        if(arr[0]=='0') queue.add(0);
        int maxCanReach = 0;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            if(curr==n-1) return true;
            int start = Math.max(curr+minJump,maxCanReach);
            int end = Math.min(curr+maxJump,n-1);
            maxCanReach = Math.max(maxCanReach,end);
            for(int i=start;i<=end;i++){
                if(arr[i]=='0'){
                    arr[i]='1';
                    queue.add(i);
                }
            }
        }
        return false;
    }
}
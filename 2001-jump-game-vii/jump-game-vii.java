class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
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
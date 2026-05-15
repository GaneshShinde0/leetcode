class Solution {
    public int maxCount(int[] banned, int n, long maxSum) {
        Set<Integer> bannedSet = new HashSet<>();
        int k = Math.min(n,(int) (Math.floor(-1 + Math.sqrt(1+8*maxSum))/2));
        long currSum = k*(k+1l)/2;
        int count = k;
        for(int b:banned){
            if(!bannedSet.contains(b)){
                bannedSet.add(b);
                if(b<=k){
                    currSum-=b;
                    count-=1;
                }
            }
        }
        for(int i=k+1;i<=n;i++){
            if(currSum+i>maxSum) return count;
            if(!bannedSet.contains(i)){
                currSum+=i;
                count++;
            }
        }
        return count;

    }
}
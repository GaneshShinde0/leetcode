// If multiple characters are same then take all times expect highest.
class Solution {
    public int minCostInitial(String colors, int[] neededTime) {
        int n = colors.length();
        int res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(neededTime[0]);
        for(int i=1;i<n;i++){
            if(colors.charAt(i)==colors.charAt(i-1)){
                pq.add(neededTime[i]);
                res+=pq.poll();
            }else{
                pq.clear();
                pq.add(neededTime[i]);
            }
        }
        return res;
    }
    
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        int res = 0;
        int max = neededTime[0];
        for(int i=1;i<n;i++){
            if(colors.charAt(i)==colors.charAt(i-1)){
                res+=Math.min(max,neededTime[i]);
                max = Math.max(neededTime[i],max);
            }else{
                max = neededTime[i];
            }
        }
        return res;
    }
}
/*
0 1 3 6
0 1 7 12
*/
class Solution{
    public int maxScore(int[] cardPoints, int k){
        int n = cardPoints.length;
        int[] fromFront = new int[k+1];
        int[] fromBack = new int[k+1];
        for(int i=0;i<k;i++){
            fromFront[i+1] = fromFront[i]+cardPoints[i];
            fromBack[i+1] = fromBack[i]+cardPoints[n-i-1];
        }
        int res = 0;
        for(int i=0;i<=k;i++){
            res = Math.max(fromFront[i]+fromBack[k-i],res);
        }
        return res;
    }
}
class SolutionInitial {
    HashMap<String, Integer> hm;
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length, start = 0, end = n-1;
        this.hm = new HashMap<>();
        return helper(n,0,end,k,cardPoints);
    }
    private int helper(int n, int start, int end, int k, int[] cardPoints){
        if(start>end || k==0) return 0;
        if(hm.containsKey(start+"-"+end)) return hm.get(start+"-"+end);
        // System.out.println(start+"-"+end);
        int left = helper(n,start+1, end, k-1, cardPoints)+cardPoints[start];
        int right = helper(n, start, end-1, k-1, cardPoints) + cardPoints[end];
        hm.put(start+"-"+end, Math.max(left, right));
        return hm.get(start+"-"+end);
    }

}
class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length(), curr = 0;
        int[] res = new int[n];
        for(int i = 0;i<n;i++){
            char c = seq.charAt(i);
            if(c=='('){
                res[i] = curr;
                curr++;
            }else{
                curr--;
                res[i] = curr;
            }
            res[i] = res[i]%2;
        }
        return res;
    }
}
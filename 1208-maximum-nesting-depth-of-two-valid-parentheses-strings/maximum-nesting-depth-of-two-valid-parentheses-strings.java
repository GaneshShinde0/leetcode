class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length(), curr = 0;
        int[] res = new int[n];
        for(int i = 0;i<n;i++){
            char c = seq.charAt(i);
            if(c=='('){
                res[i] = curr%2;
                curr++;
            }else{
                curr--;
                res[i] = curr%2;
            }
        }
        return res;
    }
}
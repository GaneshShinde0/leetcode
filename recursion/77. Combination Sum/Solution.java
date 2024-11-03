class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        combinations(n,1,k,new ArrayList<>(),res);
        return res;
    }
    public void combinations(int n, int curr, int k, List<Integer> comb, List<List<Integer>> res){
        if(k==0){
            res.add(new ArrayList<Integer>(comb));
            return;
        }
        for(int i=curr;i<=n;i++){
            comb.add(i);
            combinations(n,i+1,k-1,comb,res);
            comb.remove(comb.size()-1);
        }
    }
}

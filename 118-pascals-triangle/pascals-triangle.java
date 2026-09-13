class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows==0) return res;
        res.add(List.of(1));
        for(int i=1;i<numRows;i++){
            List<Integer> curr = new ArrayList<>();
            List<Integer> prev = res.get(i-1);
            curr.add(1);
            for(int j=1;j<prev.size();j++){
                curr.add(prev.get(j)+prev.get(j-1));
            }
            curr.add(1);
            res.add(curr);
        }
        return res;
    }
}
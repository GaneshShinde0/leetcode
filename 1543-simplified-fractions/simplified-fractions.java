class Solution {
    public List<String> simplifiedFractions(int n) {
        List<String> res = new ArrayList<>();
        List<Integer> denoms = new ArrayList<>();
        Set<Double> set = new HashSet<>();
        for(int i=2;i<=n;i++){
            denoms.add(i);
        }
        for(int i:denoms){
            for(int k=1;k<i;k++){
                if(set.contains(1.0*k/i)) continue;
                res.add(k+"/"+i);
                set.add(1.0*k/i);
            }
        }
        return res;
    }
}
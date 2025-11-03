class Solution {
    public int numberOfBoomerangsInitial(int[][] points) {
        int n = points.length;
        int res = 0;
        for(int i=0;i<n;i++){
            HashMap<Double,Integer> hm = new HashMap<>();
            for(int j=0;j<n;j++){
                // if(i==j) continue;
                double ij = Math.sqrt(((points[i][0]-points[j][0])*(points[i][0]-points[j][0]) + (points[i][1]-points[j][1])*(points[i][1]-points[j][1])));
                hm.put(ij,hm.getOrDefault(ij,0)+1);
            }
            // System.out.println(hm);
            for(Map.Entry<Double,Integer> e: hm.entrySet()){
                if(e.getValue()>1){
                    if(e.getValue()>2){
                        res+=e.getValue()*(e.getValue()-1);
                        continue;
                    }
                    res+=(e.getValue());
                }
            }
        }
        return res;
    }
    public int numberOfBoomerangs(int[][] points) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int boomerangs = 0;
        for (int[] p1 : points) {
            for (int[] p2 : points)
                boomerangs += map.merge((p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]), 1, Integer::sum) - 1;
            map.clear();
        }
        return boomerangs * 2;
    }
}
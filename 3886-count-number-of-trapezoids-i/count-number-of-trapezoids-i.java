class Solution {
    public int countTrapezoids(int[][] points) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int[] point: points){
            hm.put(point[1],hm.getOrDefault(point[1],0)+1);
        }
        int mod = 1000000007;
        long res = 0;
        long sum = 0;
        for(Map.Entry<Integer,Integer> e: hm.entrySet()){
            long numOfEdges = (1l*e.getValue()*(e.getValue()-1))/2;
            res = (res+numOfEdges*sum)%mod;
            sum = (sum+numOfEdges)%mod;
        }
        return (int)res;
    }
}
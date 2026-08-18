class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int n = workers.length, m = bikes.length;
        int maxDistance = 0;
        for(int[] w:workers){
            for(int[] b:bikes){
                maxDistance = Math.max(maxDistance, Math.abs(w[0]-b[0])+Math.abs(w[1]-b[1]));
            }
        }
        List<int[]>[] buckets = new List[maxDistance+1];
        for(int i=0; i<=maxDistance; i++) buckets[i] = new ArrayList<int[]>();
        for(int j=0;j<n;j++){
            for(int i=0;i<m;i++){
                int[] b = bikes[i], w = workers[j];
                int dist =  Math.abs(w[0]-b[0])+Math.abs(w[1]-b[1]);
                if(buckets[dist]==null) buckets[dist] = new ArrayList<>();
                buckets[dist].add(new int[]{j,i});
            }
        }
        Set<Integer> visitedWorkers = new HashSet<>();
        Set<Integer> visitedBikes = new HashSet<>();
        int[] res = new int[n];
        for(int i=0;i<=maxDistance;i++){
            // if(buckets[i].size()==0) continue;
            for(int[] curr:buckets[i]){
                if(!visitedWorkers.contains(curr[0])&&!visitedBikes.contains(curr[1])){
                    visitedWorkers.add(curr[0]);
                    visitedBikes.add(curr[1]);
                    res[curr[0]]=curr[1];
                }
            }
        }
        return res;
    }
}
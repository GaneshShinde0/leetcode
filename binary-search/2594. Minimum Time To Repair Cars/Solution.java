class Solution {
    public long repairCars(int[] ranks, int cars) {
        int n = ranks.length;
        int minRank = ranks[0];
        int maxRank = ranks[0];
        int[] rankFreq = new int[101];
        
        for(int rank:ranks){
            rankFreq[rank]++;
            minRank=Math.min(minRank,rank);
            maxRank=Math.max(maxRank,rank);
        } 
        long low = 1, high = 1l*minRank*cars*cars;// Taking long as 10^6 * 10^5
        while(low<high){
            long mid = (low+high)/2; // Mid basically represents number of cars repaired
            long carsRepaired = 0;
            for(int rank =minRank;rank<=maxRank;rank++){
                carsRepaired += rankFreq[rank]*(long)Math.sqrt(mid/(long)rank);
            }
            if(carsRepaired>=cars){
                high=mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
}

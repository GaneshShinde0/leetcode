class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] result = new String[n];
        int[] scoreCopy = Arrays.copyOf(score,n);
        Arrays.sort(scoreCopy);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(scoreCopy[i],n-i);
        }
        for(int i=0;i<n;i++){
            int rank = map.get(score[i]);
            if(rank==1) result[i] = "Gold Medal";
            else if(rank==2) result[i] = "Silver Medal";
            else if(rank==3) result[i] = "Bronze Medal";
            else result[i] = String.valueOf(rank);
        }
        return result;
    }
}

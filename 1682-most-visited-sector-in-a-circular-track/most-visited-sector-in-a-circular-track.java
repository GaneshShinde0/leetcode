class Solution {
    public List<Integer> mostVisited(int n, int[] rounds) {
        int[] count = new int[n+1];
        int max =0;
        for(int i=1;i<rounds.length;i++){
            if(rounds[i-1]<rounds[i]){
                for(int j=rounds[i-1];j<rounds[i];j++){
                    count[j%(n+1)]++;
                    max = Math.max(count[j%(n+1)],max);
                }
            }else{
                for(int j=rounds[i-1];j<=n;j++){
                    count[j%(n+1)]++;
                    max = Math.max(count[j%(n+1)],max);
                }
                for(int j=1;j<rounds[i];j++){
                    count[j%(n+1)]++;
                    max = Math.max(count[j%(n+1)],max);
                }
            }
            // System.out.println(Arrays.toString(count));
        }
        count[rounds[rounds.length-1]]++;
        max = Math.max(count[(rounds[rounds.length-1])%(n+1)],max);
        List<Integer> li = new ArrayList<>();
        for(int i=0;i<=n;i++){
            if(count[i]==max) li.add(i);
        }
        return li;
    }
}
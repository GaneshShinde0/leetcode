class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int n = values.length;
        int[][] temp = new int[n][2];
        for(int i=0;i<n;i++){
            temp[i][0]=values[i];
            temp[i][1]=labels[i];
        }
        Arrays.sort(temp,(a,b)->Integer.compare(b[0],a[0]));
        Map<Integer,Integer> valToLbl= new HashMap<>();
        int i=0;
        int res = 0;
        for(int[] arr:temp){
            System.out.println(Arrays.toString(arr));
        }
        while(numWanted>0&&i<n){
            if(valToLbl.getOrDefault(temp[i][1],0)<useLimit){
                valToLbl.put(temp[i][1],valToLbl.getOrDefault(temp[i][1],0)+1);
                res+=temp[i][0];
                numWanted--;
            }
            i++;
        }
        return res;
    }
}
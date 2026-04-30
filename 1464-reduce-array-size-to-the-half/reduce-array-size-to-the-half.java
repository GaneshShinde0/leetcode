class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int a:arr){
            hm.put(a, hm.getOrDefault(a,0)+1);
        }
        int n = hm.size();
        int[][] elementAndFreq = new int[n][2];
        int i = 0;
        for(Map.Entry<Integer, Integer> e:hm.entrySet()){
            elementAndFreq[i][0] = e.getKey();
            elementAndFreq[i][1] = e.getValue();
            i++;
        }
        Arrays.sort(elementAndFreq,(a,b)->Integer.compare(b[1],a[1]));
        int total = arr.length, reducedTotal=total;
        for(i=0;i<n;i++){
            reducedTotal-=elementAndFreq[i][1];
            if(reducedTotal<=total/2){
                return Math.max(i+1,1);
            }
        }
        return 1;
    }
}
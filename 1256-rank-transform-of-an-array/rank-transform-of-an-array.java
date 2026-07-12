class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        HashMap<Integer,Integer> hm= new HashMap<>();
        TreeSet<Integer> ts = new TreeSet<>();
        for(int i=0;i<n;i++) ts.add(arr[i]);
        int rnk = 1;
        for(int a:ts){
            hm.put(a,rnk);
            rnk++;
        }
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            res[i]= hm.get(arr[i]);
        }
        return res;

    }
}
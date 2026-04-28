class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> li = new ArrayList<>();
        for(int[] g:grid){
            for(int i:g) li.add(i);
        }
        Collections.sort(li);

        int mid = li.get(li.size()/2);
        int ops = 0;

        for(int i=0;i<li.size();i++){
            if(Math.abs(li.get(i)-mid)%x==0){
                ops+=Math.abs(li.get(i)-mid)/x;
            }else{
                return -1;
            }
        }
        return ops;
    }
}
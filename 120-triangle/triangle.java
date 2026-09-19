class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        for(int i=n-1;i>0;i--){
            List<Integer> curr = triangle.get(i);
            for(int j=0;j<curr.size()-1;j++){
                int temp = Math.min(curr.get(j),curr.get(j+1))+triangle.get(i-1).get(j);
                triangle.get(i-1).set(j,temp);
            }   
        }
        return (int) triangle.get(0).get(0);
    }
}
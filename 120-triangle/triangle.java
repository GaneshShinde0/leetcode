class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for(int i=triangle.size()-1;i>=0;i--){
            List<Integer> li = triangle.get(i);
            for(int j=0;j<li.size()-1;j++){
                Integer temp = Math.min(li.get(j),li.get(j+1))+triangle.get(i-1).get(j);
                triangle.get(i-1).set(j,temp);
            }
            // System.out.println(triangle.get(i));
        }
        return (int) triangle.get(0).get(0);
    }
}
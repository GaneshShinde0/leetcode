class Solution {
    public int minAreaRect(int[][] points) {
        HashSet<List<Integer>> visited = new HashSet<>();
        int res = Integer.MAX_VALUE;
        for(int[] point : points){
            List<Integer> li1 = Arrays.asList(point[0],point[1]);
            for(List<Integer> temp:visited){
                if(visited.contains(Arrays.asList(point[0],temp.get(1))) && visited.contains(Arrays.asList(temp.get(0),point[1]))){
                    int size = Math.abs(temp.get(0)-point[0])*Math.abs(point[1]-temp.get(1));
                    res = Math.min(size, res);
                }
            }
            visited.add(li1);
        }
        return res==Integer.MAX_VALUE?0:res;
    }
}
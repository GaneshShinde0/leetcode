class Solution {
    // public int minAreaRect(int[][] points) {
    //     HashSet<List<Integer>> visited = new HashSet<>();
    //     int res = Integer.MAX_VALUE;
    //     for(int[] point : points){
    //         List<Integer> li1 = Arrays.asList(point[0],point[1]);
    //         for(List<Integer> temp:visited){
    //             if(visited.contains(Arrays.asList(point[0],temp.get(1))) && visited.contains(Arrays.asList(temp.get(0),point[1]))){
    //                 int size = Math.abs(temp.get(0)-point[0])*Math.abs(point[1]-temp.get(1));
    //                 res = Math.min(size, res);
    //             }
    //         }
    //         visited.add(li1);
    //     }
    //     return res==Integer.MAX_VALUE?0:res;
    // }

    static class Point{
        int x;
        int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o){
            if(this == o) return true;
            if(o==null||getClass()!=o.getClass()) return false;
            Point point = (Point) o;
            // Two points are equal if their x and y co-ordinates are same.
            return x == point.x && y==point.y;
        }

        @Override
        public int hashCode(){
            // Using Objects.hash() is a convenient way to combine multiple fields.
            return Objects.hash(x,y);
            // Alternatively, a common manual hash is : return 31*x+y;
        }
    }

    public int minAreaRect(int[][] points){
        // Use a HashSet of our custom Point Objects
        HashSet<Point> visited = new HashSet<>();
        int res = Integer.MAX_VALUE;
        // Iterate through each input point
        for(int[] point:points){
            // Convert current input array to a point object P1
            Point currPoint = new Point(point[0],point[1]);
            for(Point visitedPoint: visited){
                int x1 = currPoint.x;
                int y1 = currPoint.y;
                int x2 = visitedPoint.x;
                int y2 = visitedPoint.y;
                if(x1==x2 || y1==y2) continue;

                Point p3 = new Point(x1,y2);
                Point p4 = new Point(x2,y1);

                if(visited.contains(p3) && visited.contains(p4)){
                    int currArea = Math.abs(x1-x2)*Math.abs(y1-y2);
                    res = Math.min(res, currArea);
                }
            }

            // After checking against all previously visited points, add the point to visited.
            visited.add(currPoint);
        }
        return res == Integer.MAX_VALUE?0:res;
    }
}
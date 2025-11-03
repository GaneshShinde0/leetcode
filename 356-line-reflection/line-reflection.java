/*
Approach:

1. Find max and min point(x). The reflection line must be x = (max+min)/2;
min----p1--|--p2----max
For each points 
p1(x)-min = max-p2(x) => p1(x)+p2(x) = min+max
So the problem becomes two sum. To solve it, we can use HashSet or presort arry by x;
*/
class Solution {
    public boolean isReflected(int[][] points) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        HashSet<String> set = new HashSet<>();
        for(int[] p:points){
            set.add(p[0]+","+p[1]);
            //min--p1--------|--------p2--max
            //min--------p1--|--p2--------max
            //p1-------------|------------p2
            max = Math.max(p[0],max);
            min = Math.min(p[0],min);
        }
        int sum = max+min;
        for(int[] p:points){
            if(!set.contains((sum-p[0])+","+p[1]))return false;
        }
        return true;
    }
}
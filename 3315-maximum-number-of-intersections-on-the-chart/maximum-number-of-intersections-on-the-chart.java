class Solution {
    class Pair {
        int nPoints, /* how many same points are there*/
        above, /* how many above points started from current */ 
        below; /* for how many points I am the end*/
    }
    public int maxIntersectionCount(int[] y) {
        //using treemap to sort the y-axis in ascending order
        TreeMap<Integer, Pair> yaxis = new TreeMap<>();
        int n = y.length;
        for(int i=0; i<n; i++) {
            Pair pair = yaxis.get(y[i]);
            if(pair == null) {
                pair = new Pair();
                yaxis.put(y[i], pair);
            }
            if(i!=0) { //when i==0 you will not have [i-1]
                updateLines(pair, y[i], y[i-1]);
            }
            if(i+1!=n) { //when i==n-1 you will not have [i+1]
                updateLines(pair, y[i], y[i+1]);
            }
            pair.nPoints++;
        }
        int answer = 0, soFar=0;
        for(Map.Entry<Integer, Pair> entry : yaxis.entrySet()) {
            Pair pair = entry.getValue();
            soFar-=pair.below;
            // I am at current point, 
            //Now my current point should include how many I had before without end
            answer = Math.max(soFar+pair.nPoints, answer);
            //I have to consider how many forward points from me + how many I had before without end
            soFar+=pair.above;
            answer=Math.max(soFar, answer);
        }
        return answer;
    }

    void updateLines(Pair pair, int current, int prevOrNext) {
        //check with current point with previous & next value
        if(current<prevOrNext) { 
            //prevOrNext point can be i-1 | i+1
            pair.above++;
        } else {
            pair.below++;
        }
    }
}
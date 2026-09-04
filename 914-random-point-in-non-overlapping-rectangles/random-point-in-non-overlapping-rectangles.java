// class Solution {

//     int[][] rects;
//     List<Integer> psum = new ArrayList<>();
//     int tot = 0;
//     Random rand = new Random();

//     public Solution(int[][] rects) {
//         this.rects = rects;
//         for (int[] x : rects){
//             tot += (x[2] - x[0] + 1) * (x[3] - x[1] + 1);
//             psum.add(tot);
//         }
//     }

//     public int[] pick() {
//         int targ = rand.nextInt(tot);

//         int lo = 0;
//         int hi = rects.length - 1;
//         while (lo != hi) {
//             int mid = (lo + hi) / 2;
//             if (targ >= psum.get(mid)) lo = mid + 1;
//             else hi = mid;
//         }

//         int[] x = rects[lo];
//         int width = x[2] - x[0] + 1;
//         int height = x[3] - x[1] + 1;
//         int base = psum.get(lo) - width * height;
//         return new int[]{x[0] + (targ - base) % width, x[1] + (targ - base) / width};
//     }
// }

class Solution
{
    private final int[][] rects;
    private final TreeMap<Integer, int[]> idxRectMap;
    private int idx;
    private final Random rand;
    
    public Solution(int[][] rects)
    {
        this.idx = 0;
        this.rects = rects;
        this.idxRectMap = new TreeMap<>();
        buildMap();
        this.rand = new Random();
    }
    
    private void buildMap()
    {
        for (int[] rect : rects)
        {
            int area = (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
            idxRectMap.put(idx, rect);
            idx += area;
        }
    }
    
    public int[] pick()
    {
        int currIdx = rand.nextInt(idx);
        int keyIdx = idxRectMap.floorKey(currIdx);
        int[] rect = idxRectMap.get(keyIdx);
        return getRandomPoint(rect);
    }
    
    private int[] getRandomPoint(int[] rect)
    {
        int[] point = new int[2];
        point[0] = rand.nextInt(rect[2] - rect[0] + 1) + rect[0];
        point[1] = rand.nextInt(rect[3] - rect[1] + 1) + rect[1];
        return point;
    }
}
class SolutionDoesNotWork {
    int[][] points;
    int n;
    long totalArea;
    TreeMap<Long,Integer> tm;
    Random rand = new Random();
    public SolutionDoesNotWork(int[][] rects) {
        this.points = rects;
        this.n = points.length;
        this.totalArea = 0;
        for(int rect[]:rects){
            int height = rect[3]-rect[1]+1;
            int width = rect[2]-rect[0]+1;
            totalArea+=height*width;
        }
        long curr = 0;
        int i=0;
        tm = new TreeMap<>();
        for(int rect[]:rects){
            int height = rect[3]-rect[1]+1;
            int width = rect[2]-rect[0]+1;
            curr+=height*width;
            tm.put(curr,i++);
        }
    }
    
    public int[] pick() {
        Integer rndm = tm.ceilingEntry((long) (rand.nextLong(totalArea))).getValue();
        int height = points[rndm][3]-points[rndm][1]+1;
        int width = points[rndm][2]-points[rndm][0]+1;
        
        return new int[]{(int) (points[rndm][0]+width*Math.random()),(int)(points[rndm][1]+height*Math.random())};
    }
}

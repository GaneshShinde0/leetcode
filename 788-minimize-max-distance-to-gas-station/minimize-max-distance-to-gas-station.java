import java.util.*;
import static java.lang.Math.*;

class Solution {
    public double minmaxGasDist(int[] stations, int K) {
        int N = stations.length;
        double distUpper = (stations[N - 1] - stations[0]) / (double)(K + 1);
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        for (int i = 0; i < N - 1; i++) {
            double interval = stations[i + 1] - stations[i];
            int ki = (int) Math.floor(interval / distUpper);
            double actualDist = interval / (ki + 1);
            K -= ki;
            pq.add(new double[]{actualDist, interval, ki});
        }

        while (K-- > 0) {
            double[] top = pq.poll();
            double dist = top[0];
            double interval = top[1];
            int ki = (int) top[2] + 1;
            pq.add(new double[]{interval / (ki + 1), interval, ki});
        }

        return pq.peek()[0];
    }
}
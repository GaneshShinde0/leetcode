
class Solution {
    public int shortestPathWithHops(int n, int[][] edges, int s, int d, int k) {
        List<int[]>[] con = new ArrayList[n];
        for (int[] e : edges) {
            if (con[e[0]] == null) {
                con[e[0]] = new ArrayList<>();
            }
            if (con[e[1]] == null) {
                con[e[1]] = new ArrayList<>();
            }
            con[e[0]].add(new int[]{e[1], e[2]});
            con[e[1]].add(new int[]{e[0], e[2]});
        }
        PriorityQueue<int[]> q = new PriorityQueue((a, b) -> ((int[]) a)[0] - ((int[]) b)[0]);
        q.add(new int[]{0, k, s});
        int[][] dist = new int[n][k + 1];
        Arrays.stream(dist).forEach(a -> Arrays.fill(a, Integer.MAX_VALUE));
        boolean[][] mark = new boolean[n][k + 1];
        dist[s][k] = 0;
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            if (mark[temp[2]][temp[1]]) {
                continue;
            }
            mark[temp[2]][temp[1]] = true;
            if (temp[2] == d) {
                return temp[0];
            }
            if (con[temp[2]] == null) {
                continue;
            }
            for (int[] p : con[temp[2]]) {
                if (p[1] + temp[0] < dist[p[0]][temp[1]]) {
                    dist[p[0]][temp[1]] = p[1] + temp[0];
                    q.add(new int[]{dist[p[0]][temp[1]], temp[1], p[0]});
                }
                if (temp[1] > 0 && temp[0] < dist[p[0]][temp[1] - 1]) {
                    dist[p[0]][temp[1] - 1] = temp[0];
                    q.add(new int[]{dist[p[0]][temp[1] - 1], temp[1] - 1, p[0]});
                }
            }
        }
        return -1;
    }
}
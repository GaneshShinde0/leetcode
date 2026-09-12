class Solution {
    public boolean validSquareInitial(int[] p1, int[] p2, int[] p3, int[] p4) {
        double distP1P2 = dist(p1,p2);
        double distP1P3 = dist(p1,p3);
        double distP1P4 = dist(p1,p4);
        double distP2P3 = dist(p2,p3);
        double distP2P4 = dist(p2,p4);
        double distP3P4 = dist(p3,p4);
        if(Arrays.equals(p1,p2)||Arrays.equals(p1,p3)||Arrays.equals(p1,p4)||Arrays.equals(p2,p3)
            || Arrays.equals(p2,p4)|| Arrays.equals(p3,p4)) return false;
        // System.out.println
        if(Math.abs(distP1P2-distP1P3)<1e-9 && Math.abs(distP2P4-distP3P4)<1e-9 && Math.abs(distP1P2-distP2P4)<1e-9 && Math.abs(dist(p1,p4)-dist(p2,p3))<1e-9) return true;
        if(Math.abs(distP1P2-distP1P4)<1e-9 && Math.abs(distP2P3-distP3P4)<1e-9 && Math.abs(distP1P2-distP2P3)<1e-9  && Math.abs(dist(p1,p3)-dist(p2,p4))<1e-9) return true;
        if(Math.abs(distP1P3-distP1P4)<1e-9 && Math.abs(distP2P4-distP2P3)<1e-9 && Math.abs(distP1P3-distP2P4)<1e-9  && Math.abs(dist(p1,p2)-dist(p3,p4))<1e-9) return true;
        return false;
    }

    private double dist(int[] p1, int[] p2){
        return Math.sqrt((p1[0]-p2[0])*(p1[0]-p2[0]) + (p1[1]-p2[1])*(p1[1]-p2[1]));
    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] p = { p1, p2, p3, p4 };
        Arrays.sort(p, (l1, l2) ->
            l2[0] == l1[0] ? l1[1] - l2[1] : l1[0] - l2[0]
        );
        return (
            dist(p[0], p[1]) != 0 &&
            dist(p[0], p[1]) == dist(p[1], p[3]) &&
            dist(p[1], p[3]) == dist(p[3], p[2]) &&
            dist(p[3], p[2]) == dist(p[2], p[0]) &&
            dist(p[0], p[3]) == dist(p[1], p[2])
        );
    }
}
class Solution {
        public int countLatticePoints(int[][] circles) {
        Set<Integer> res = new HashSet<>();
        for (int[] c : circles)
            for (int i = -c[2]; i <= c[2]; i++)
                for (int j = -c[2]; j <= c[2]; j++)
                    if (i * i + j * j <= c[2] * c[2])
                        res.add((c[0] + i) * 1000 + c[1] + j);
        return res.size();
    }
}
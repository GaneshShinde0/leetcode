class Solution {
    public int maxDepthBST(int[] order) {
        TreeMap<Integer, Integer> m = new TreeMap<>();
        int res = 0;
        for (int i : order) {
            Map.Entry<Integer, Integer> l = m.floorEntry(i);
            Map.Entry<Integer,Integer> r = m.ceilingEntry(i);
            int prevLevel = Math.max(l == null ? 0 : l.getValue(), r == null ? 0 : r.getValue());
            m.put(i, 1 + prevLevel);
            res = Math.max(res, 1+prevLevel);
        }
        return res;
    }
}
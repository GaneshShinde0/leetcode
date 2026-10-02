class Solution {
    public int maxPotholes(String road, int budget) {
        List<Integer> list = new ArrayList<>();
        int cur = 0;
        for (int i = 0; i < road.length(); i++) {
            boolean isHole = road.charAt(i) == 'x';
            if (isHole) {
                cur++;
            } else {
                if (cur > 0) list.add(cur);
                cur = 0;
            }
        }
        if (cur > 0) list.add(cur);
        Collections.sort(list, (a, b) -> b - a);
        int res = 0;
        for (int n : list) {
            if (budget <= 1) break;
            if (n + 1 <= budget) {
                budget -= n + 1;
                res += n;
            } else {
                res += budget - 1;
                budget = 0;
            }
        }
        return res;
    }
}
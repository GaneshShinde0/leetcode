class Solution {
    public int catchMaximumAmountofPeople(int[] team, int dist) {
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<team.length; i++) {
            if (team[i] == 0) {
                list.add(i);
            }
        }
        
        int cnt = 0;
        int start = 0;

        for (int i=0; i<team.length; i++) {
            if (team[i] == 1) {
                int left = (i - dist < 0)? 0 : i - dist;
                int right = (i + dist >= team.length)? team.length - 1 : i + dist;
                int idx = find(list, left, start);

                if (idx != list.size() && list.get(idx) <= right) {
                    cnt++;
                    start = idx + 1;
                }
            } 
        }

        return cnt;
    }

    public int find(List<Integer> list, int target, int start) {
        int left = start - 1;
        int right = list.size();

        while (left + 1 != right) {
            int mid = left + (right - left) / 2;

            if (list.get(mid) >= target) {
                right = mid;
            } else {
                left = mid;
            }
        } 

        return right;
    }
}
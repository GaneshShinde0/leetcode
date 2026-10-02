class StatisticsTracker {
    TreeSet<int[]> minh, maxh;
    Queue<int[]> q;
    long s;
    int n;
    HashMap<Integer, Integer> cnt;
    TreeSet<int[]> ms;
    public StatisticsTracker() {
        minh = new TreeSet<>((o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);
        maxh = new TreeSet<>((o1, o2) -> o2[0] != o1[0] ? o2[0] - o1[0] : o1[1] - o2[1]);
        ms = new TreeSet<>((o1, o2) -> o1[0] != o2[0] ? o2[0] - o1[0] : o1[1] - o2[1]);
        q = new LinkedList<>();
        cnt = new HashMap<>();
    }
    // time = O(logn), space = O(n)
    public void addNumber(int number) {
        add(number, n);
        rebalance();
        q.offer(new int[]{number, n});
        s += number;
        n++;
        cnt.put(number, cnt.getOrDefault(number, 0) + 1);
        if (cnt.get(number) > 1) ms.remove(new int[]{cnt.get(number) - 1, number});
        ms.add(new int[]{cnt.get(number), number});
    }
    // time = O(logn), space = O(n)
    public void removeFirstAddedNumber() {
        int[] t = q.poll();
        int x = t[0], idx = t[1];
        s -= x;
        ms.remove(new int[]{cnt.get(x), x});
        cnt.put(x, cnt.get(x) - 1);
        if (cnt.get(x) == 0) cnt.remove(x);
        else ms.add(new int[]{cnt.get(x), x});
        if (minh.contains(t)) minh.remove(t);
        else maxh.remove(t);
        rebalance();
    }
    // time = O(1), space = O(n)
    public int getMean() {
        int sz = minh.size() + maxh.size();
        return (int)(s / sz);
    }
    // time = O(logn), space = O(n)
    public int getMedian() {
        int sz = minh.size() + maxh.size();
        if (sz % 2 == 1) return minh.first()[0];
        return Math.max(minh.first()[0], maxh.first()[0]);
    }
    // time = O(logn), space = O(n)
    public int getMode() {
        return ms.first()[1];
    }

    private void add(int x, int idx) {
        maxh.add(new int[]{x, idx});
        minh.add(maxh.first());
        maxh.remove(maxh.first());
    }

    private void rebalance() {
        while (minh.size() < maxh.size()) {
            minh.add(maxh.first());
            maxh.remove(maxh.first());
        }
        if (minh.size() - maxh.size() > 1) {
            maxh.add(minh.first());
            minh.remove(minh.first());
        } 
    }
}

/**
 * Your StatisticsTracker object will be instantiated and called as such:
 * StatisticsTracker obj = new StatisticsTracker();
 * obj.addNumber(number);
 * obj.removeFirstAddedNumber();
 * int param_3 = obj.getMean();
 * int param_4 = obj.getMedian();
 * int param_5 = obj.getMode();
 */
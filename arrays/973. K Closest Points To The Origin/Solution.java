class Solution {
    public int[][] kClosestNaive(int[][] points, int k) {
        // Arrays.sort(points,(a,b)->Double.compare(Math.sqrt(a[0]*a[0]+a[1]*a[1]),Math.sqrt(b[0]*b[0]+b[1]*b[1])));
        Arrays.sort(points,(a,b)->a[0]*a[0]+a[1]*a[1]-b[0]*b[0]-b[1]*b[1]);
        int[][] res = new int[k][2];
        for(int i=0;i<k;i++){
            res[i][0]=points[i][0];
            res[i][1]=points[i][1];
        }
        return res;
    }

    public int[][] kClosestUsingPriorityQueue(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
        for (int[] p : points) {
            pq.offer(p);
            if (pq.size() > K) {
                pq.poll();
            }
        }
        int[][] res = new int[K][2];
        while (K > 0) {
            res[--K] = pq.poll();
        }
        return res;
    }

    public int[][] kClosest(int[][] points, int k) {
        int len = points.length, l = 0, r = len - 1;
        while (l <= r) {
            int mid = helper(points, l, r);
            if (mid < k) {
                l = mid + 1;
            } else if (k < mid) {
                r = mid - 1;
            } else {
                break;
            }
        }
        return Arrays.copyOfRange(points, 0, k);
    }

    private int helper(int[][] nums, int left, int right) {
        int i = left;
        int j = right + 1;

        swap(nums, left, (left + right) >>> 1);
        int[] pivot = nums[left];

        while (i < j) {
            do {
                i++;
            } while (i < right && compare(nums[i], pivot) < 0);
            do {
                j--;
            } while (compare(pivot, nums[j]) < 0);

            if (i < j)
                swap(nums, i, j);
        }
        swap(nums, left, j);
        return j;
    }

    private void swap(int[][] nums, int i, int j) {
        int[] tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private int compare(int[] p1, int[] p2) {
        return p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1];
    }
}

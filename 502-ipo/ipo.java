class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] profitsToCapital = new int[n][2];
        for(int i=0;i<n;i++){
            profitsToCapital[i][0]=profits[i];
            profitsToCapital[i][1]=capital[i];
        }

        Arrays.sort(profitsToCapital,(a,b)->Integer.compare(a[1],b[1]));  // Ordering projects by increasing order of their capital required.
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(n, Collections.reverseOrder());
        int ptr = 0;
        for(int i=0;i<k;i++){
            while(ptr<n && profitsToCapital[ptr][1]<=w){ // We will add until we have capital.
                q.add(profitsToCapital[ptr][0]);
                ptr++;
            }
            if(q.isEmpty()) break;
            w+=q.poll();  // We will choose best profit that can be made with current captal.
        }
        return w;
    }
}
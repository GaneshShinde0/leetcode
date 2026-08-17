class Solution {

    int[][] f;
    int[][] maxl;
    int[][] maxr;

    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        f = new int[n][n];
        maxl = new int[n][n];
        maxr = new int[n][n];
        for (int left = n - 1; left >= 0; --left) {
            maxl[left][left] = maxr[left][left] = stoneValue[left];
            int sum = stoneValue[left],
                suml = 0;
            for (int right = left + 1, i = left - 1; right < n; ++right) {
                sum += stoneValue[right];
                while (i + 1 < right && (suml + stoneValue[i + 1]) * 2 <= sum) {
                    suml += stoneValue[i + 1];
                    ++i;
                }
                if (left <= i) {
                    f[left][right] = Math.max(f[left][right], maxl[left][i]);
                }
                if (i + 1 < right) {
                    f[left][right] = Math.max(
                        f[left][right],
                        maxr[i + 2][right]
                    );
                }
                if (suml * 2 == sum) {
                    f[left][right] = Math.max(
                        f[left][right],
                        maxr[i + 1][right]
                    );
                }
                maxl[left][right] = Math.max(
                    maxl[left][right - 1],
                    sum + f[left][right]
                );
                maxr[left][right] = Math.max(
                    maxr[left + 1][right],
                    sum + f[left][right]
                );
            }
        }
        return f[0][n - 1];
    }
}
class SolutionONxNxN{
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;

        int[] prefixSum = new int[n];
        prefixSum[0] = stoneValue[0];
        for(int i=1;i<n;i++){
            prefixSum[i] = prefixSum[i-1]+stoneValue[i];
        }

        int res = 0;

        int[][] memo = new int[n][n];
        for(int[] m:memo) Arrays.fill(m,-1);

        memo[0][n-1] = 0;
        for(int len = n; len>=1;len--){
            for(int left = 0; left<=n-len; left++){
                int right = left + len -1;
                int sum = memo[left][right];
                if(sum==-1) continue;
                int leftSum = 0, rightSum = 0;
                for(int i=left;i<right;i++){
                    leftSum = prefixSum[i]-(left==0?0:prefixSum[left-1]);
                    rightSum = prefixSum[right]-prefixSum[i];
                    if(leftSum>rightSum){
                        if(sum+rightSum>memo[i+1][right]){
                            memo[i+1][right] = sum + rightSum;
                        }
                    }else if(leftSum<rightSum){
                        if(sum+leftSum>memo[left][i]){
                            memo[left][i] = sum+leftSum;
                        }
                    }else{
                        if(sum+rightSum>memo[i+1][right]){
                            memo[i+1][right] = sum + rightSum;
                        }
                        if(sum+leftSum>memo[left][i]){
                            memo[left][i] = sum+leftSum;
                        }
                    }
                }
            }
        }
        for(int i = 0; i < n; i++) {
            res = Math.max(res, memo[i][i]);
        }
        return res;
    }
}
class SolutionMLE{
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;

        int[] prefixSum = new int[n];
        prefixSum[0] = stoneValue[0];
        for(int i=1;i<n;i++){
            prefixSum[i] = prefixSum[i-1]+stoneValue[i];
        }

        int res = 0;
        Queue<int[]> queue = new LinkedList<>();
        // Left, Right, currSum
        queue.add(new int[]{0,n-1, 0});

        int[][] memo = new int[n][n];
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int left = curr[0], right = curr[1], sum = curr[2];
            if(left==right){
                res = Math.max(sum, res);
            }else{
                int leftSum = 0, rightSum = 0;
                for(int i=left;i<right;i++){
                    leftSum = prefixSum[i]-(left==0?0:prefixSum[left-1]);
                    rightSum = prefixSum[right]-prefixSum[i];
                    if(leftSum>rightSum){
                        if(sum+rightSum>memo[i+1][right]){
                            memo[i+1][right] = sum + rightSum;
                            queue.add(new int[]{i+1,right, sum+rightSum});
                        }
                    }else if(leftSum<rightSum){
                        if(sum+leftSum>memo[left][i]){
                            memo[left][i] = sum+leftSum;
                            queue.add(new int[]{left,i, sum+leftSum});
                        }
                    }else{
                        if(sum+rightSum>memo[i+1][right]){
                            memo[i+1][right] = sum + rightSum;
                            queue.add(new int[]{i+1,right, sum+rightSum});
                        }
                        if(sum+leftSum>memo[left][i]){
                            memo[left][i] = sum+leftSum;
                            queue.add(new int[]{left,i, sum+leftSum});
                        }
                    }
                }
            }
        }
        return res;
    }
}
class SolutionTLE {
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;

        int[] prefixSum = new int[n];
        prefixSum[0] = stoneValue[0];
        for(int i=1;i<n;i++){
            prefixSum[i] = prefixSum[i-1]+stoneValue[i];
        }

        int res = 0;
        Queue<int[]> queue = new LinkedList<>();
        // Left, Right, currSum
        queue.add(new int[]{0,n-1, 0});

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int left = curr[0], right = curr[1], sum = curr[2];
            if(left==right){
                res = Math.max(sum, res);
            }else{
                int leftSum = 0, rightSum = 0;
                for(int i=left;i<right;i++){
                    leftSum = prefixSum[i]-(left==0?0:prefixSum[left-1]);
                    rightSum = prefixSum[right]-prefixSum[i];
                    if(leftSum>rightSum){
                        queue.add(new int[]{i+1,right, sum+rightSum});
                    }else if(leftSum<rightSum){
                        queue.add(new int[]{left,i, sum+leftSum});
                    }else{
                        queue.add(new int[]{i+1,right, sum+rightSum});
                        queue.add(new int[]{left,i, sum+leftSum});
                    }
                }
            }
        }
        return res;
    }
}
class Solution {
    private int[][] memo;
    private int N;
    private String[] words;

    
    public int maxDistanceTLE(String[] wordsArr) {
        this.words = wordsArr;
        this.N = words.length;
        if (N <= 1) {
            return 0;
        }
        memo = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(memo[i], -1);
        }
        return distance(0,words.length-1);
    }

    private int distance(int i, int j){
        if(i>=j) return 0;
        if(memo[i][j]!=-1) return memo[i][j];
        int res = 0;
        if(!words[i].equals(words[j])) {
            res = j-i+1;
        }
        memo[i][j]=Math.max(res,Math.max(distance(i+1,j),distance(i,j-1)));
        return memo[i][j];
    }

    public int maxDistance(String[] words){
        int left = 0, right = words.length-1, res = 0, n = words.length;
        while(left<=right){
            if(!words[left].equals(words[n-1])){
                res = n-left;
                break;
            }
            if(!words[right].equals(words[0])){
                res = right+1;
                break;
            }
            left++;
            right--;
        }
        return res;
    }
}
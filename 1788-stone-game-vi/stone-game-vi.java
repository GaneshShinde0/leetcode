class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int[] freq = new int[201];
        for (int i = 0; i < aliceValues.length; i++)
            freq[aliceValues[i] + bobValues[i]]++;

        int diff = -Arrays.stream(bobValues).sum();
        int pos = 0;
        for (int v = 200; v > 1; v--) {
            int c = freq[v];
            if (c > 0) {
                diff += v * (pos % 2 == 0 ? (c + 1) / 2 : c / 2);
                pos += c;
            }
        }

        return Integer.signum(diff);
    }
}
class SolutionNLogN {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;

        int[] combined = IntStream.range(0, n).map(i -> aliceValues[i] + bobValues[i]).toArray();
        Arrays.sort(combined);

        int diff = -Arrays.stream(bobValues).sum();
        for (int i = n - 1; i >= 0; i -= 2)
            diff += combined[i];

        return Integer.signum(diff);
    }
}

class SolutionInitial {
    public int stoneGameVII(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length, bobSum=0;
        // Take Value difference from Alices Perspective.
        int[][] valueSum = new int[n][2];
        for(int i=0;i<n;i++){
            valueSum[i][1] = aliceValues[i]+bobValues[i];
            valueSum[i][0] = i; 
            bobSum += bobValues[i];
        }
        Arrays.sort(valueSum, (a,b)-> Integer.compare(b[1],a[1]));
        int aliceScore = 0, bobScore = 0;
        for(int i=0;i<n;i++){
            if(i%2==0)aliceScore += aliceValues[valueSum[i][0]];
            else bobScore += bobValues[valueSum[i][0]];
        }
        if(aliceScore>bobScore) return 1;
        else if(aliceScore<bobScore) return -1;
        return 0;
    }
}
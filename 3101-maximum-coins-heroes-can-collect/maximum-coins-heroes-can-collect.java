/*
n heroes with power
m monsters with power

any hero can defeat any monster.. if monsters[j]<=heroes[i];

coins[i] is what we get when we defeat ith monster.

Return maximum number of coins that ith hero can collect from battle.
- Multitple heroes can defeat monsters. 
- Each monster can be defeated by given hero only once.

We need last index when monsterPower<=heroPower
*/
class Solution {
    public long[] maximumCoins(int[] heroes, int[] monsters, int[] coins) {
        int n = heroes.length, m = monsters.length;
        int[][] monsterScore = new int[m][2];
        for(int i=0;i<m;i++){
            monsterScore[i][0] = monsters[i];
            monsterScore[i][1] = coins[i];
        }
        // Sort them by their score
        Arrays.sort(monsterScore, (a,b)-> Integer.compare(a[0], b[0]));
        // Keep PrefixSum for easy lookup
        long[] prefSum = new long[m];
        prefSum[0] = monsterScore[0][1];
        for(int i=1;i<m;i++){
            prefSum[i] = monsterScore[i][1]+prefSum[i-1];
        }
        long[] res = new long[n];
        for(int i=0;i<n;i++){
            int pow = heroes[i];
            int left = 0, right = m-1;
            while(left<=right){
                int mid = left+(right-left+1)/2;
                if(monsterScore[mid][0]>pow){ // Might be first valid power.
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
            if(left>0) res[i] = prefSum[left-1];
        }
        return res;
    }
}
/*
Dry Run 
1,1,2,5,3,

1,1,2,3,5

Pow = 1
left = 0, right = 4

mid = 0+(4-2)/2
right = mid-1= right = 1.

pow = 2
left = 0, right = 4
mid = 2;
left = 2, right = 4

mid = 3
left = 2, right = 3...

mid = 2
left = mid, right = 3 

*/

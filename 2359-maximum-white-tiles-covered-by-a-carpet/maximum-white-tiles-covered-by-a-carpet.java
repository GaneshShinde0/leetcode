/*
Everytime we have three posibilities, 
- Take current Right Range
- If currEnd-prevStart >carpetLen;
    - Take from prevStart -> to carPetLn 
    - Take from currEnd to carpetLen on left side. 
*/

class Solution {
    // Line Sweep Algorithm
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles,(a,b)->Integer.compare(a[0],b[0]));
        int left = 0, n = tiles.length;
        int maxLen = 0, gaps = 0;
        for(int right=0;right<tiles.length;right++){
            int currEnd = tiles[right][1];
            if(right>0) gaps+=tiles[right][0]-tiles[right-1][1]-1;
            while(currEnd-tiles[left][1]>carpetLen){
                left++;
                gaps-=tiles[left][0]- tiles[left-1][1]-1;
            }
            // maxLen = Math.max(maxLen, Math.min(carpetLen-gaps, currEnd-tiles[left][0]-gaps));
            int covered = Math.min(carpetLen,currEnd - tiles[left][0] + 1) - gaps;

            maxLen = Math.max(maxLen, covered);
        }
        return maxLen;
    }
}
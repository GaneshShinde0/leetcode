class Solution {
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int n = aliceArrows.length;//12 given in question
        int[] bobArrows = new int[n];
        for(int mask=0;mask<(1<<n);mask++){
            int currArrows = numArrows;
            int[] temp = new int[n];
            for(int j=0;j<n;j++){
                if(currArrows>aliceArrows[j] && ((1<<j) & mask) !=0){
                    temp[j] = aliceArrows[j]+1;
                    currArrows-=temp[j];
                }
            }
            if(check(temp, bobArrows)){
                bobArrows = temp;
                bobArrows[0]+=currArrows;
            }
        }
        // System.out.println(Arrays.toString(bobArrows));
        return bobArrows;
    }
    private boolean check(int[] a, int[] b){
        int aScore = 0, bScore = 0;
        for(int i=0;i<a.length;i++){
            if(a[i]>b[i]){
                aScore+=i;
            }else if(a[i]<b[i]){
                bScore+=i;
            }
        }
        return aScore>bScore;
    }
}
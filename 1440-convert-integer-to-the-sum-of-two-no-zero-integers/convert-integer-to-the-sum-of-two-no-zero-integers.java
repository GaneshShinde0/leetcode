class Solution {
    public int[] getNoZeroIntegers(int n) {
        int a=n-1,b=1;
        while(String.valueOf(a).indexOf('0')!=-1||String.valueOf(b).indexOf('0')!=-1){
            a--;
            b++;
        }
        return new int[]{a,b};
    }
}
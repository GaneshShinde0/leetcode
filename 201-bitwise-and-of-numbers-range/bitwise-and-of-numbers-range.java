class Solution {
    public int rangeBitwiseAndInitial(int left, int right) {
        // System.out.println("Right: "+right+", right>>=1: "+ (right>>1));
        while(right>left){
            right=right&(right-1);
        }
        return right; // Return right will also work.
    }

    public int rangeBitwiseAnd(int left, int right){
        int shift = 0;
        while(left<right){
            left>>=1;
            right>>=1;
            shift+=1;
        }
        return left<<shift;
    }


}
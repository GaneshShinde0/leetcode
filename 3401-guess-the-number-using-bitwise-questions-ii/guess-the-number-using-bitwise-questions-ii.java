/** 
 * Definition of commonBits API (defined in the parent class Problem).
 * int commonBits(int num);
 */

public class Solution extends Problem {
    public int findNumber() {
        int r = 0;
        for(int i = 1;i<Math.pow(2,30);i<<=1){
            if(commonBits(i)>commonBits(i)){
                r|=i;
            }
        }
        return r;
    }
}
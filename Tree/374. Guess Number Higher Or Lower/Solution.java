/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        if(guess(n)==0) return n;
        int start = 0;
        while(start<=n){
            // Following two lines will lead to overflow
            // long mid1 = (start+n)/2;
            // int mid = (int) mid1;
            // Hence always use start+(end-start)/2
            int mid = start + (n-start)/2;
            int guess = guess(mid);
            System.out.println("Guess: "+guess);
            System.out.println("Mid: "+mid);
            System.out.println("Start: "+start);
            System.out.println("End: "+n);

            if(guess==-1) n = mid;
            if(guess==1) start = mid;
            if(guess==0) return mid;
        }
        return -1;
    }
}

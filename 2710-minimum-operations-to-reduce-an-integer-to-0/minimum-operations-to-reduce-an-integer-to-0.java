/*

Intuition

- Take a look at the binary of n:
- If there is an alone 1 like 00001;
    - It takes atleast one operation to remove
    - So we do res++ and n>>=1
- If there are multiple 1s like ...000111;
    - We cant remove them in one single operation, so it takes atleast two operation to remove.
    - We add 1 001000;
    - We do n++ and remove the last bit 0.

So Basically
If its single 1, res+=1;
if its multiple 1s res+=2
*/

class Solution {
    public int minOperations(int n) {
        int res = 0;
        while(n>0){
            if((n&3)==3){ // Seeing if last two bits were 11 If yes we will increment result by 1 and n by 1 (basically making 011 to 100 which can be converted to 0 later)
                n++; // n+1 will also take care of scenarios like 10111111; Making 10111111 to 1000000
                res++;
            }else{
                res+=n&1; // See if last bit was 1
                n>>=1; // Right Shift Digit By 1 on every stage.
            }
        }
        return res;
    }
}

/*
Time Complexity = 32*n => n
*/
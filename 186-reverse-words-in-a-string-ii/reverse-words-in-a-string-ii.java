/*
Can do this easily if extra space is allowed ... but we have to do it inplace
// Algorithm:
First we can reverse whole array. 

Example: 
input 
["t","h","e"," ","s","h","o","w"];

After Reversing: ["w","o","h","s", " ", "e", "h", "t"];
- start with left = 0, right =0, increment right until we find space.
- Store right in some variable.
- Swap elements from left with right until we reach mid.
- Reassign left with right+1, right with right +1;
*/
class Solution {
    public void reverseWords(char[] s) {
        int left = 0, right = s.length-1, n = s.length;
        // 
        while(left<right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
        left = 0;
        right = 0;
        for(;right<n;right++){
            if(s[right]==' '){
                int prevRight = right;
                right--;
                while(left<right){
                    char temp = s[left];
                    s[left] = s[right];
                    s[right] = temp;
                    left++;
                    right--;
                }
                right = prevRight;
                left = prevRight+1;
            }
        }
        while(left<right){
            right--;
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
        }
    }
}
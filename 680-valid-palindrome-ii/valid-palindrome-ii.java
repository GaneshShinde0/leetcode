// class Solution {
//     public boolean validPalindrome(String s) {
//         int c = 1;
//         int left = 0;
//         int right = s.length()-1;
//         while(left<=right){
//             if(s.charAt(left)==s.charAt(right)){
//                 right--;
//                 left++;
//             }else{
//                 break;
//             }
//         }
//         if(left>=right) return true;
//         int tempLeft = left-1;
//         int tempRight = right+1;
//         while(left<=right){
//             if(s.charAt(left)==s.charAt(right)){
//                 right--;
//             }else if(s.charAt(left)==s.charAt(right-1)){
//                 right-=2;
//                 c--;
//             }
//             left++;
//         }
//         if(c<0){
//             c=1;
//             while(tempLeft<=tempRight){
//                 if(s.charAt(tempLeft)==s.charAt(tempRight)){
//                     tempLeft++;
//                 }if(s.charAt(tempLeft+1)==s.charAt(tempRight)){
//                     tempLeft+=2;
//                     c--;
//                 }
//                 tempRight--;
//             }
//         }
//         return c>=0;
//     }
// }

class Solution {
    public boolean validPalindromeInitialSolution(String s) {
        int c = 1;
        int left = 0;
        int n = s.length();
        int right = n-1;

        int tempLeft =-1,tempRight=-1;
        while(left<right){
            if(s.charAt(left)==s.charAt(right)){
                right--;
                left++;
            }else if(c==1&&s.charAt(left)==s.charAt(right-1)){
                if(tempLeft==-1 && tempRight==-1){
                    tempLeft = left;
                    tempRight = right;
                }
                right--;
                c--;
            }else{
                break;
            }
        }
        if(left>=right) return true;
        left = 0;
        right= n-1;
        c = 1;
        // System.out.println("Left: "+left+", Right: "+right);
        while(left<=right){
            if(s.charAt(left)==s.charAt(right)){
                right--;
                left++;
            }else if(c==1&&s.charAt(left+1)==s.charAt(right)){
                left++;
                c--;
            }else{
                return false;
            }
        }
        return c==0;
    }

    public boolean validPalindrome(String s) {
        int left = 0, right = s.length()-1;
        while(left<right){
            if(s.charAt(left)==s.charAt(right)){
                left++;
                right--;
            }else{
                return isPalindrome(s,left+1,right)||isPalindrome(s,left,right-1);
            }
        }
        return true;
    }

    private boolean isPalindrome(String s, int left, int right){
        while(left<right){
            if(s.charAt(left++)!=s.charAt(right--)) return false;
        }
        return true;
    }

}
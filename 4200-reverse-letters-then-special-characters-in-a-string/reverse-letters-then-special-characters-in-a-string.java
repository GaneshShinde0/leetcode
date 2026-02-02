class Solution {
    public String reverseByType(String s) {
        String sc = "!@#$%^&*()";
        int left = 0, right = s.length()-1;
        char[] res = s.toCharArray();
        while(left<right){
            if(sc.indexOf(s.charAt(left))>-1){
                left++;
            }else if(sc.indexOf(s.charAt(right))>-1){
                right--;
            }else{
                res[left] = s.charAt(right);
                res[right]= s.charAt(left);
                left++;
                right--;
            }
        }
        left = 0; right = s.length()-1;
        while(left<right){
            if(sc.indexOf(s.charAt(left))==-1){
                left++;
            }else if(sc.indexOf(s.charAt(right))==-1){
                right--;
            }else{
                res[left] = s.charAt(right);
                res[right]= s.charAt(left);
                left++;
                right--;
            }
        }
        return new String(res);
    }
}
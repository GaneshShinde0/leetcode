class Solution {
    public boolean isStrobogrammatic(String num) {
        String num2 = (new StringBuilder(num).reverse().toString());
        for(int i=0;i<num.length();i++){
            boolean check1 = (num.charAt(i)=='6'&&num2.charAt(i)=='9');
            boolean check2 = (num.charAt(i)=='9'&&num2.charAt(i)=='6');
            boolean check3 = (num.charAt(i)=='8'&&num2.charAt(i)=='8');
            boolean check4 = (num.charAt(i)=='1'&&num2.charAt(i)=='1');
            boolean check5 = (num.charAt(i)=='0'&&num2.charAt(i)=='0');
            if(check1||check2||check3||check4||check5)continue;
            else return false;
        }
        return true;
    }
}
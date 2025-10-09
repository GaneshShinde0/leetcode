class Solution {
    public boolean isStrobogrammaticInitial(String num) {
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
    Map<Character, Character> map = Map.of('0','0','1','1','6','9','8','8','9','6');
    public boolean isStrobogrammatic(String num) {
        int left = 0;
        int right = num.length() - 1;

        while (left < right) {
            char cLeft = num.charAt(left);
            char cRight = num.charAt(right);

            if (!map.containsKey(cLeft) || map.get(cLeft) != cRight) {
                return false;
            }
            left++;
            right--;
        }

        if (left == right) {
            char c = num.charAt(left);
            return c == '0' || c == '1' || c == '8';
        }

        return true;


    }
}
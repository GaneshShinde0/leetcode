class Solution {
    Map<Character, Character> hm = Map.of('0','0','1','1','6','9','8','8','9','6');

    public boolean confusingNumber(int n) {
        String num = String.valueOf(n);
        StringBuilder sb = new StringBuilder();
        for(char c:num.toCharArray()){
            sb.insert(0,hm.get(c));
        }
        String num2 = sb.toString();
        if(num.equals(num2)) return false;
        int size= sb.length();
        for(int i=0;i<num.length();i++){
            boolean check1 = (num.charAt(i)=='6'&&num2.charAt(size-i-1)=='9');
            boolean check2 = (num.charAt(i)=='9'&&num2.charAt(size-i-1)=='6');
            boolean check3 = (num.charAt(i)=='8'&&num2.charAt(size-i-1)=='8');
            boolean check4 = (num.charAt(i)=='1'&&num2.charAt(size-i-1)=='1');
            boolean check5 = (num.charAt(i)=='0'&&num2.charAt(size-i-1)=='0');
            if(check1||check2||check3||check4||check5)continue;
            else return false;
        }
        return true;
    }
}
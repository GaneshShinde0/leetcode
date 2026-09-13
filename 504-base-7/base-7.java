class Solution {
    public String convertToBase7(int num) {
        if(num==0) return "0";
        StringBuilder sb = new StringBuilder();
        boolean neg = false;
        if(num<0){
            num = -num;
            neg = true;
        }
        while(num>0){
            sb.insert(0,num%7);
            num = num/7;
        }
        if(neg) sb.insert(0,"-");
        return sb.toString();
    }
}
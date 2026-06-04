class Solution {
    public int totalWaviness(int num1, int num2) {
        int res = 0;
        for(int i=num1;i<=num2;i++){
            res+=isWavi(i);
        }
        return res;
    }
    private int isWavi(int num){
        String s = ""+num;
        int w = 0;
        if(s.length()<=2) return w;
        for(int i=0;i<s.length()-2;i++){
            if((s.charAt(i)>s.charAt(i+1) && s.charAt(i+1)<s.charAt(i+2))||(s.charAt(i)<s.charAt(i+1) && s.charAt(i+1)>s.charAt(i+2))) w++;
        }
        return w;
    }
}
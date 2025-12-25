class Solution {
    public int iswavi(int n){
        String str=Integer.toString(n);
        if(str.length()<2){
            return 0;
        }
        int count=0;
        for(int i=0;i<str.length()-2;i++){
            int ch1=str.charAt(i)-'0';
            int ch2=str.charAt(i+1)-'0';
            int ch3=str.charAt(i+2)-'0';
            if((ch1<ch2&&ch2>ch3)||(ch1>ch2&&ch3>ch2)){
                count++;
            }
        }
        return count;
    }
    public int totalWaviness(int num1, int num2) {
        int count=0;
        for(int i=num1;i<=num2;i++){
            count+=iswavi(i);
        }
        return count;
    }
}
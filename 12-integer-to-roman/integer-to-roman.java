class Solution {
    public String intToRoman(int num) {
        String ones[]={"","I","II","III","IV","V","VI","VII","VIII","IX"};
        String tens[]= {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String hundreds[] = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String thousands[] = {"","M","MM","MMM"};
        StringBuilder sb = new StringBuilder();
        return sb.append(thousands[num/1000]).append(hundreds[(num%1000)/100]).append(tens[(num%100)/10]).append(ones[num%10]).toString();
    }
}
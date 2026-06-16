class Solution {
    public String maxValue(String n, int x) {
        StringBuilder sb = new StringBuilder(n);
        boolean isNegative = n.charAt(0)=='-';
        boolean taken = false;
        for(int i=0;i<n.length();i++){
            char c = n.charAt(i);
            if(c=='-') continue;
            else if((isNegative && (c-'0')>x)||(!isNegative && (c-'0')<x)){
                sb.insert(i,x);
                taken = true;
                break;
            }
        }
        if(!taken)sb.append(x);
        return sb.toString();
    }
}
class Solution {
    public String digitSum(String s, int k) {
        if(s.length()<=k) return s;
        StringBuilder sb = new StringBuilder();
        int i=0;
        while(i<s.length()){
            int sum = 0, temp = i;
            while(temp<Math.min(i+k, s.length())){
                sum+=s.charAt(temp)-'0';
                temp++;
            }
            sb.append(sum);
            i = temp;
        }
        return digitSum(sb.toString(), k);
    }
}
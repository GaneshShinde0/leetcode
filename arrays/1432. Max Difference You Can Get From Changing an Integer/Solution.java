class Solution {
    public int maxDiff(int num) {
        String s = String.valueOf(num);
        String max = new String(s);
        String min = new String(s);
        int n = s.length();
        int i=0;
        while(i<n){
            if(s.charAt(i)!='9'){
                max = max.replace(s.charAt(i)+"","9");
                // System.out.println(max);
                break;
            }
            i++;
        }
        i=0;
        while(i<n){
            if(s.charAt(i)!='1'&&s.charAt(i)!='0'){
                if(i>0){
                    min = s.replace(s.charAt(i)+"","0");
                }else{
                    min = s.replace(s.charAt(i)+"","1");
                }
                break;
            }
            i++;
        }
        // System.out.println(min+"-"+max);
        int a = Integer.parseInt(max);
        int b = Integer.parseInt(min);
        return a-b;
    }
}

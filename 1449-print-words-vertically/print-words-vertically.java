class Solution {
    public List<String> printVertically(String s) {
        String[] arr = s.split(" ");
        List<String> res = new ArrayList<>();
        int max = 0;
        for(String t:arr){
            max = Math.max(t.length(),max);
        }
        for(int i=0;i<max;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<arr.length;j++){
                if(arr[j].length()<=i){
                    sb.append(" ");
                }else{
                    sb.append(arr[j].charAt(i));
                }
            }
            res.add(rtrim(sb));
        }
        return res;
    }

    private String rtrim(StringBuilder sb) {
        int end = sb.length();
        while(end > 0 && sb.charAt(end - 1) == ' '){
            end--;
        }
        
        return sb.substring(0,end);
    }
}
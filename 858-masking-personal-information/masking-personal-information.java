class Solution {
    public String maskPII(String s) {
        StringBuilder sb = new StringBuilder();
        s=s.replaceAll("[+()\s-]","");
        if(s.indexOf("@")==-1){
            int len = s.length();
            sb.append("***-***-").append(s.substring(len-4));
            int rem = len%10;
            if(rem!=0)sb.insert(0,"+"+("*".repeat(rem))+"-");
        }else{
            s=s.toLowerCase();
            String[] arr = s.split("@");
            arr[0] = arr[0].charAt(0)+"*".repeat(5)+arr[0].charAt(arr[0].length()-1);
            sb.append(arr[0]).append("@").append(arr[1]);
        }
        return sb.toString();
    }
}
class Solution {
    private final String NEITHER = "Neither";
    private final String IPV4 = "IPv4";
    private final String IPV6 = "IPv6";

    public String validIPAddress(String queryIP) {
        if(queryIP.indexOf(":")!=-1){
            return isIPv6(queryIP.toLowerCase());
        }else if(queryIP.indexOf(".")!=-1){
            return isIPv4(queryIP);
        }else{
            return "Neither";
        }
    }
    private String isIPv6(String query){
        String[] arr = query.split("\\:",-1);
        if(arr.length!=8) return NEITHER;
        for(String block:arr){
            if(!validIPv6Block(block)) return NEITHER;
        }
        return IPV6;
    }
    private boolean validIPv6Block(String block){
        if(block.length()==0||block.length()>4) return false;
        for(char c:block.toCharArray()){
            if(!((c>='0' && c<='9') || (c>='a' && c<='f' ))) return false;
        }
        return true;
    }
    private String isIPv4(String query){
        String[] arr = query.split("\\.",-1);
        if(arr.length!=4) return NEITHER;
        for(String block:arr){
            if(!validIPv4Block(block)) return NEITHER;
        }
        return IPV4;
    }
    private boolean validIPv4Block(String block){
        if(block.length()==0||(block.startsWith("0") && block.length()!=1)||block.length()>3) return false;
        int sum = 0;        
        for(char c:block.toCharArray()){
            if(!(c>='0' && c<='9')) return false;
            sum = sum*10+(c-'0');
        }
        return sum<256;
    }
}
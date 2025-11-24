public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s:strs){
            sb.append(s.replace("|","||")).append("|,");
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for(int i=0;i<s.length();i++){
            if(i<n-1 && s.charAt(i)=='|' && s.charAt(i+1)=='|'){
                sb.append("|");
                i++;
            }else if(i<n-1 && s.charAt(i)=='|' && s.charAt(i+1)==','){
                res.add(sb.toString());
                sb = new StringBuilder();
                i++;
            }else{
                sb.append(s.charAt(i));
            }
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
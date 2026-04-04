class Solution {
    public String decodeCiphertext59ms(String encodedText, int rows) {
        int n = encodedText.length();
        int skip = n/rows;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<skip;i++){
            int curr = i;
            while(curr<n){
                sb.append(encodedText.charAt(curr));
                curr+=skip+1;
            }
        }
        while(sb.length()>0 && sb.charAt(sb.length()-1)==' '){
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }
    public String decodeCiphertext(String encodedText, int rows) {
        int n = encodedText.length();
        int skip = n/rows;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<skip;i++){
            int curr = i;
            while(curr<n){
                sb.append(encodedText.charAt(curr));
                curr+=skip+1;
            }
        }
        return sb.toString().stripTrailing();
    }
}
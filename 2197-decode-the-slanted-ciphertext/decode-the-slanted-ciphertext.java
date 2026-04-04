class Solution {
    public String decodeCiphertext59ms(String encodedText, int rows) {
        int n = encodedText.length();
        int cols = n/rows;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<cols;i++){
            int curr = i;
            while(curr<n){
                sb.append(encodedText.charAt(curr));
                curr+=cols+1;
            }
        }
        while(sb.length()>0 && sb.charAt(sb.length()-1)==' '){
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }
    public String decodeCiphertext40ms(String encodedText, int rows) {
        int n = encodedText.length();
        int cols = n/rows;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<cols;i++){
            int curr = i;
            while(curr<n){
                sb.append(encodedText.charAt(curr));
                curr+=cols+1;
            }
        }
        return sb.toString().stripTrailing();
    }

    public String decodeCiphertext36ms(String encodedText, int rows) {
        int n = encodedText.length();
        int cols = n/rows;
        char[] encodedTextArr = encodedText.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<cols;i++){
            int curr = i;
            while(curr<n){
                sb.append(encodedTextArr[curr]);
                curr+=cols+1;
            }
        }
        return sb.toString().stripTrailing();
    }

    public String decodeCiphertext(String encodedText, int rows) {
        int n = encodedText.length();
        int cols = n/rows;
        char[] encodedTextArr = encodedText.toCharArray();
        StringBuilder sb = new StringBuilder(n);
        for(int i=0;i<cols;i++){
            int curr = i;
            while(curr<n){
                sb.append(encodedTextArr[curr]);
                curr+=cols+1;
            }
        }
        int i = sb.length() - 1;
        while (i >= 0 && sb.charAt(i) == ' ') {
            i--;
        }
        sb.setLength(i + 1);
        return sb.toString();
    }
}
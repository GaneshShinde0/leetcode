class Solution {
    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();
        int curr=1,end =word.length(),count=1;
        char prev = word.charAt(0);
        while(curr<end){
            if(count==9||word.charAt(curr)!=prev){
                sb.append(count);
                sb.append(prev);
                prev=word.charAt(curr);
                count=1;
            }else{
                count++;
            }
            curr++;
        }
        sb.append(count);
        sb.append(prev);
        return sb.toString();
    }
}

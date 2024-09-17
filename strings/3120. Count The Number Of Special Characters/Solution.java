class Solution {
    public int numberOfSpecialChars(String s) {
        int count=0;
        for(int i=25;i>=0;i--){
            if(s.indexOf('a'+i)!=-1 && s.indexOf('A'+i)!=-1){
                count++;
            }
        }
        return count;
    }
}

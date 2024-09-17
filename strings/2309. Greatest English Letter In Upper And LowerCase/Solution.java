class Solution {
    public String greatestLetter(String s) {
        for(int i=25;i>=0;i--){
            if(s.indexOf('a'+i)!=-1 && s.indexOf('A'+i)!=-1){
                return Character.toString('A'+i);
            }
        }
        return "";
    }
}

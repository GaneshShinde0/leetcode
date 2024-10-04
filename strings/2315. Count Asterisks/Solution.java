class Solution {
    public int countAsterisks(String s) {
        boolean inPipe= false;
        int count =0;
        for(char c:s.toCharArray()){
            if(!inPipe && c=='*') count++;
            if(c=='|')inPipe=!inPipe;
        }
        return count;
    }
}

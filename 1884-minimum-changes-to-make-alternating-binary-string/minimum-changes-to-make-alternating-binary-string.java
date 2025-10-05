class Solution {
    public int minOperations(String s) {
        boolean turn = true;
        int count = 0,count2=0;
        for(char c:s.toCharArray()){
            if(turn&&c=='0') ;
            else if(!turn&&c=='1') ;
            else count++;
            turn = !turn;
        }
        for(char c:s.toCharArray()){
            if(!turn&&c=='0') ;
            else if(turn&&c=='1') ;
            else count2++;
            turn = !turn;
        }
        int res = Math.min(count,count2);
        return Math.min(res,s.length()-res);
    }
}
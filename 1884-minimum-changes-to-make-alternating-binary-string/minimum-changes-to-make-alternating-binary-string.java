class Solution {
    public int minOperationsInitial(String s) {
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

    public int minOperations(String s) {
        int count1 = 0; // changes needed if starting with '0'
        int count2 = 0; // changes needed if starting with '1'

        for (int i = 0; i < s.length(); i++) {
            char expectedIfStart0 = (i % 2 == 0) ? '0' : '1';
            char expectedIfStart1 = (i % 2 == 0) ? '1' : '0';

            if (s.charAt(i) != expectedIfStart0) count1++;
            if (s.charAt(i) != expectedIfStart1) count2++;
        }

        return Math.min(count1, count2);
    }
}
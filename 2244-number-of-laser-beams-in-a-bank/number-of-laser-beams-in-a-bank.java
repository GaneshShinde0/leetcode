class Solution {
    public int numberOfBeams(String[] bank) {
        int prev = countOnes(bank[0]);
        int res = 0;
        for(int i=1;i<bank.length;i++){
            int curr = countOnes(bank[i]);
            if(curr!=0){
                res += curr*prev;
                prev = curr;
            }
        }
        return res;
    }
    private int countOnes(String s){
        int count = 0;
        for(char c:s.toCharArray()){
            if(c=='1') count++;
        }
        return count;
    }
}
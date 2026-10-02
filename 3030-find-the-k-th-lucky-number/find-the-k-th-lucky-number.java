class Solution {
    public String kthLuckyNumber(int k) {
        String answer = "";
         k = k +1;
        while(k!=1){
            if(k%2 ==1){
                answer = 7 + answer;
            } else{
                answer = 4 + answer;
            }
            
            k = k/2;
        }
        
        return answer;
    }
}
class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int score = 0, left = 0, right = tokens.length-1;
        Arrays.sort(tokens);
        while(left<=right){
            if(power>=tokens[left]){
                score++;
                power-=tokens[left];
                left++;
            }else if(left<right && score>0){
                score--;
                power+=tokens[right];
                right--;
            }else{
                return score;
            }
        }
        return score;
    }
}
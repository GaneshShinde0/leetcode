class Solution {
    public int maximumGain(String s, int x, int y) {
        int totalScore = 0;
        String hPP = x>y?"ab":"ba"; //highPriorityPair
        String lPP = hPP.equals("ab")?"ba":"ab";

        String afterFirstPass = removeSubstring(s,hPP);
        int count = (s.length()-afterFirstPass.length())/2;
        totalScore += count*Math.max(x,y);

        String afterSecondPass = removeSubstring(afterFirstPass,lPP);
        count = (afterFirstPass.length()-afterSecondPass.length())/2;
        totalScore += count*Math.min(x,y);
        return totalScore;
    }

    private String removeSubstring(String input, String target) {
        Stack<Character> charStack = new Stack<>();
        // Iterate through each character in the input string
        for(int i = 0;i<input.length(); i++){
            char curr = input.charAt(i);
            if(curr == target.charAt(1) && !charStack.isEmpty() && charStack.peek() == target.charAt(0)){
                charStack.pop();
            }else{
                charStack.push(curr);
            }
        }
        StringBuilder remainingChars = new StringBuilder();
        while (!charStack.isEmpty()) {
            remainingChars.append(charStack.pop());
        }
        return remainingChars.reverse().toString();
    }
    private String removeSubstringTLE(String input, String targetPair) {
        while(input.indexOf(targetPair)!=-1){
            input = input.replaceAll(targetPair,"");
        }
        return input;
    }
}
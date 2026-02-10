class Solution {
    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        Stack<Character> stk = new Stack<>();
        Set<Character> present = new HashSet<>();
        for(char c: s.toCharArray()) freq[c-'a']++;
        for(char c:s.toCharArray()){
            freq[c-'a']--;
            if(present.contains(c)) continue;
            while(!stk.isEmpty() && stk.peek()>c && freq[stk.peek()-'a']>0){
                present.remove(stk.peek());
                stk.pop();
            }
            stk.push(c);
            present.add(c);
        }
        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty()){
            sb.append(stk.pop());
        }
        return sb.reverse().toString();
    }
}
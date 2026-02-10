class Solution {
    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        Set<Character> present = new HashSet<>();
        Stack<Character> stk = new Stack<>();
        for(char c: s.toCharArray()) freq[c-'a']++;
        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            freq[curr-'a']--;
            if(present.contains(curr)) continue;
            while(!stk.isEmpty() && stk.peek()>curr && freq[stk.peek()-'a']>0){
                present.remove(stk.peek());
                stk.pop();
            }
            stk.push(curr);
            present.add(curr);
        }
        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty()) sb.append(stk.pop());
        return sb.reverse().toString();
    }
}
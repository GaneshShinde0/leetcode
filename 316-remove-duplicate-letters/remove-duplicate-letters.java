class Solution {
    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        Set<Character> present = new HashSet<>();
        Stack<Character> stk = new Stack<>();
        for(char c: s.toCharArray()) freq[c-'a']++;
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']--;
            if(present.contains(s.charAt(i))) continue;
            while(!stk.isEmpty() && stk.peek()>s.charAt(i) && freq[stk.peek()-'a']>0){
                present.remove(stk.peek());
                stk.pop();
            }
            stk.push(s.charAt(i));
            present.add(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty()) sb.append(stk.pop());
        return sb.reverse().toString();
    }
}
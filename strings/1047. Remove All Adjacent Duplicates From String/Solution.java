class Solution {
    public String removeDuplicatesUsingStringBuilder(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c:s.toCharArray()){
            int n=sb.length();
            if(n>0 && sb.charAt(n-1)==c){
                sb.deleteCharAt(n-1);
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public String removeDuplicatesDeque(String s){
        Deque<Character> dq = new ArrayDeque<>();
        for(char c:s.toCharArray()){
            if(!dq.isEmpty() && dq.peekLast()==c){
                dq.pollLast();
            }else{
                dq.offer(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c:dq) sb.append(c);
        return sb.toString();
    }
    // Using Two Pointer
    public String removeDuplicates(String s){
        char[] a = s.toCharArray();
        int end = -1;
        for(char c: a){
            if(end>=0 && a[end]==c){
                --end;
            }else{
                a[++end]=c;
            }
        }
        return String.valueOf(a,0,end+1);
    }
}

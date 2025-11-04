class Solution {
    public boolean isValidSimple(String s) {
        int n = s.length()/3;
        while(n>0){
            s = s.replace("abc","");
            n--;
        }
        return s.equals("");
    }
    public boolean isValidStack(String s) {
        Stack<Character> stk = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='c'){
                if(stk.size()>=2){
                    if(!(stk.pop()=='b')) return false;
                    if(!(stk.pop()=='a')) return false;
                }else return false;
            }else{
                stk.push(ch);
            }
        }
        return stk.isEmpty();
    }

    public boolean isValid(String s) {
        char[] arr = s.toCharArray();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            arr[j++] = arr[i];
            if (j >= 3 && arr[j-3] == 'a' && arr[j-2] == 'b' && arr[j-1] == 'c')
                j -= 3;
        }
        return j == 0;
    }
}
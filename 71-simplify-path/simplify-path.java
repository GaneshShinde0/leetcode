class Solution {
    public String simplifyPath(String path) {
        String[] arr = path.split("/+");
        Stack<String> stk = new Stack<>();
        System.out.println(Arrays.toString(arr));
        for(String s: arr){
            if(s.equals("..")) {if(!stk.isEmpty()) stk.pop();}
            else if(s.equals(".") || s.equals("")) continue;
            else stk.push(s);
            System.out.println(stk);
        }
        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty()) {
            sb.insert(0, "/" + stk.pop());
        }
        if(sb.toString().equals("")) return "/";
        return sb.toString();
    }

    public String simplifyPathInitial(String path) {
        StringBuilder sb = new StringBuilder();
        Stack<String> stk = new Stack<>();
        String[] arr = path.split("/+");
        // System.out.println(Arrays.toString(arr));
        for(String s:arr){
            if(s.equals(".")||s.equals("")){
                continue;
            }else if(s.equals("..")){
                if(!stk.isEmpty())stk.pop();
            }else{
                stk.push(s);
            }
        }
        while(!stk.isEmpty()){
            sb.insert(0,stk.pop());
            sb.insert(0,"/");
        }
        if(sb.toString().equals("")) return "/";
        return sb.toString();
    }
}
class Solution {
    String expression;
    int idx;
    public List<String> braceExpansionII(String expression) {
        this.expression = expression;
        this.idx = idx;
        Set<String> res = expr();
        return new ArrayList<String>(res);
    }

    // expr => term | term, expr
    private Set<String> expr(){
        Set<String> res = new TreeSet<String>();
        while(true){
            res.addAll(term());
            if(idx < expression.length() && expression.charAt(idx)==','){
                idx++;
                continue;
            }else{
                break;
            }
        }
        return res;
    }

    // term => iterm | item term
    private Set<String> term(){
        Set<String> res = new TreeSet<>();
        res.add("");
        // An item starts with { or a lowercase letter; continue matching only when this condition is met
        while(idx < expression.length() && (expression.charAt(idx)=='{'||Character.isLetter(expression.charAt(idx)))){
            Set<String> sub = item();
            Set<String> tmp = new TreeSet<String>();
            for(String s1:res){
                for(String s2:sub){
                    tmp.add(s1+s2);
                }
            }
            res = tmp;
        }
        return res;
    }

    // item => letter | {expr}
    private Set<String> item(){
        Set<String> res = new TreeSet<String>();
        if(expression.charAt(idx)=='{'){
            idx++;
            res = expr();
        }else{
            StringBuilder sb = new StringBuilder();
            sb.append(expression.charAt(idx));
            res.add(sb.toString());
        }
        idx++;
        return res;
    }
}
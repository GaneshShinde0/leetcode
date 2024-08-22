class N1678EasyInterpret {

    public String interpret1ms(String command) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        int len = command.length();
        while(idx < len){
            if(command.charAt(idx)=='G'){
                sb.append("G");
            }
            else if(command.charAt(idx)=='(' && command.charAt(idx+1)==')'){
                sb.append("o");
                idx++;
            }
            else {
                sb.append("al");
                idx += 3;
            }
            idx++;
        }
        return sb.toString();
    }
    public String interpret(String command) {
        command = command.replace("()","o");
        command = command.replace(")","");
        command = command.replace("(","");
        return command;
    }
}

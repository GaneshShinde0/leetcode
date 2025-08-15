class Solution {
    public int myAtoiWrongOne(String s) {
        s=s.trim();
        if((s.contains("-")&&s.contains("+"))||s.length()==0) return 0;
        boolean isNegative=false;
        int start =0;
        if(s.charAt(0)=='-') {
            isNegative=true;
            s=s.substring(1);
        }
        System.out.println(s);

        s = s.replaceAll("^0+","");
        String res ="";
        char[] charArray = "0123456789".toCharArray();
        
        Set<Character> digits = IntStream.range(0, charArray.length)
                    .mapToObj(i -> charArray[i]) // Convert each char to Character
                    .collect(Collectors.toCollection(HashSet::new));
        char[] arr = s.toCharArray();
        if(arr.length==0) return 0;
        else if(arr[0]=='+') start=1;
        for(int i=start;i<arr.length;i++){
            if(digits.contains(arr[i])){
                res+=arr[i];
            }else{
                break;
            }
        }
        if(res.equals("")) return 0;
        if(res.length()>10||Long.parseLong(res)>=2147483648l) return isNegative?-2147483648:2147483647;
        if (isNegative) return -1*Integer.parseInt(res);
        
        return Integer.parseInt(res);
    }


    public int myAtoi(String s) {
        String digits = "0123456789";
        StringBuilder sb = new StringBuilder();
        boolean isNegative = false,isPositive=false;
        boolean isZero = false;
        boolean isDigit = false;
        for(char c:s.toCharArray()){
            if(isDigit&& (digits.indexOf(c)==-1)) break;
            if((c==' '||c=='0')&&sb.length()==0){
                if(c=='0'){
                    isZero = true;
                    isDigit = true;
                }
                continue;
            }
            if(isPositive && isNegative) return 0;
            if(sb.length()==0 && c=='-'){
                isDigit = true;
                if(isZero) return 0;
                isNegative = true;
                continue;
            }else if (c=='+'&&sb.length()==0){
                isDigit = true;
                isPositive = true;
                continue;
            }
            if (digits.indexOf(c)!=-1){
                sb.append(c);
                isDigit = true;
            }else{
                break;
            }
        }
        String res = sb.toString();
        if(res.equals("")) return 0;
        if(res.length()>10||Long.parseLong(res)>=2147483648l) return isNegative?-2147483648:2147483647;
        if (isNegative) return -1*Integer.parseInt(res);
        
        return Integer.parseInt(res);
    }
}
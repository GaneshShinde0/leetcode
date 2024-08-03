class N1957FancyNonTripletString {
    public String makeFancyStringSlowest(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i=2;
        while(i<sb.length()){
            if(sb.charAt(i-2)==sb.charAt(i-1)&&sb.charAt(i)==sb.charAt(i-1)){
                sb.deleteCharAt(i-2);
            }else{
                i++;
            }
    
        }
        return sb.toString();
    }
    public String makeFancyString(String s) {
        if (s.length() < 3) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        int count = 1;
        
        sb.append(s.charAt(0));
        sb.append(s.charAt(1));

        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1) && s.charAt(i - 1) == s.charAt(i - 2)) {
                continue;
            }
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }

}

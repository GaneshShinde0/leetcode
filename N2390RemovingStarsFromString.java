class N2390RemovingStarsFromString {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c:s.toCharArray()){
            if (c!='*'){
                sb.append(c);
            }else{
                sb.deleteCharAt(sb.length()-1);
            }

        }
        return sb.toString();
    }
}

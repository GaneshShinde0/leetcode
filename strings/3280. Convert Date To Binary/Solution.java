class Solution {
    public String convertDateToBinary(String date) {
        String[] str = date.split("-");
        StringBuilder sb = new StringBuilder();
        for(String s: str){
            sb.append(Integer.toBinaryString(Integer.parseInt(s)));
            sb.append("-");
        }
        return sb.toString().substring(0,sb.toString().length()-1);
    }
}

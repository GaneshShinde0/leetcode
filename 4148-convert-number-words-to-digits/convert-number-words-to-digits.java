class Solution {
    public String convertNumber(String s) {
        Map<String, Integer> hm = Map.of("zero",0,"one",1,"two",2,"three",3, "four", 4, "five",5, "six",6, "seven",7, "eight",8,"nine",9);
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        System.out.println(hm);
        for(int i=0;i<=n-3;i++){
            System.out.println(s.substring(i,Math.min(n,i+3)));
            if(hm.containsKey(s.substring(i,Math.min(n,i+3)))){
                sb.append(hm.get(s.substring(i,Math.min(n,i+3))));
                i+=2;
            }else if(hm.containsKey(s.substring(i,Math.min(n,i+4)))){
                sb.append(hm.get(s.substring(i,Math.min(n,i+4))));
                i+=3;
            }else if(hm.containsKey(s.substring(i,Math.min(n,i+5)))){
                sb.append(hm.get(s.substring(i,Math.min(n,i+5))));
                i+=4;
            }
        }
        return sb.toString();
    }
}
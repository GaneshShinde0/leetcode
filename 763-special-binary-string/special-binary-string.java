class Solution {
    public String makeLargestSpecial(String s) {
        if(s.length()==0) return s;
        int anchor = 0, bal = 0;
        List<String> mountains = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            bal += s.charAt(i)=='1'?1:-1;
            if(bal==0){
                mountains.add("1"+makeLargestSpecial(s.substring(anchor+1,i))+"0");
                anchor = i+1;
            }
        }
        Collections.sort(mountains, Collections.reverseOrder());
        StringBuilder ans = new StringBuilder();
        for(String mtn:mountains) ans.append(mtn);
        return ans.toString();
    }
}
class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String,List<String>> groupToList = new HashMap<>();
        for(String s:strings){
            StringBuilder sb = new StringBuilder();
            int shift = s.charAt(0);
            for(int i=1;i<s.length();i++){
                int a = (s.charAt(i)-shift+26)%26;
                int b = (s.charAt(i-1)-shift+26)%26;
                sb.append(b-a).append(',');
            }
            groupToList.computeIfAbsent(sb.toString(),k->new ArrayList<String>()).add(s);
        }
        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<String,List<String>> e: groupToList.entrySet()){
            res.add(e.getValue());
        }
        return res;
    }
}

/*
zab is same as abc
25, 0, 1



+1
0,1,2

yza

how can i compare that
0,1,2


*/
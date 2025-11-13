class Solution {
    public String lexSmallest(String s) {
        TreeSet<String> set = new TreeSet<>();
        int n = s.length();
        for(int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder(s.substring(0,i+1));
            sb.reverse();
            sb.append(s.substring(i+1));
            // System.out.println(sb.toString());
            set.add(sb.toString());
            sb = new StringBuilder(s.substring(i+1));
            sb.reverse();
            sb.insert(0,s.substring(0,i+1));
            set.add(sb.toString());

            if(set.size()==4){
                set.pollLast();
                set.pollLast();
            }
        }
        return set.first();
    }
}
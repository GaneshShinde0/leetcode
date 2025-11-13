class Solution {
    public String lexSmallestInitial(String s) {
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
            // Following 4 lines make code faster by 45 ms
            // if(set.size()>=3){
            //     set.pollLast();
            //     set.pollLast();
            // }
        }
        return set.first();
    }
    public String lexSmallest(String s) {
        String best = s;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            StringBuilder sb1 = new StringBuilder(s.substring(0, i + 1)).reverse().append(s.substring(i + 1));
            StringBuilder sb2 = new StringBuilder(s.substring(i + 1)).reverse().insert(0, s.substring(0, i + 1));
            best = min(best, sb1.toString());
            best = min(best, sb2.toString());
        }
        return best;
    }

    private String min(String a, String b) {
        return a.compareTo(b) <= 0 ? a : b;
    }
}
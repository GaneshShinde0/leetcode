class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        String result = s;

        queue.offer(s);
        visited.add(s);

        while (!queue.isEmpty()) {
            String curr = queue.poll();
            if (curr.compareTo(result) < 0) {
                result = curr;
            }

            // Operation 1: Add 'a' to all odd indices
            char[] arr = curr.toCharArray();
            for (int i = 1; i < arr.length; i += 2) {
                arr[i] = (char)(((arr[i] - '0' + a) % 10) + '0');
            }
            String addOp = new String(arr);

            // Operation 2: Rotate right by 'b'
            String rotOp = curr.substring(curr.length() - b) + curr.substring(0, curr.length() - b);

            // Try both new states
            if (visited.add(addOp)) {
                queue.offer(addOp);
            }
            if (visited.add(rotOp)) {
                queue.offer(rotOp);
            }
        }

        return result;
    }

    public String findLexSmallestStringInitial(String s, int a, int b) {
        String res = new String(s);
        StringBuilder sb = new StringBuilder(s);
        TreeSet<String> set = new TreeSet<>();
        int n = s.length();
        while(!set.contains(sb.toString())){
            set.add(sb.toString());
            String s2 = rotateString(sb,b,n);
            String s1 = performFirstOperation(sb, a, n);
            if(compare(s1,s2,n)){
                sb = new StringBuilder(s2);
            }else{
                sb = new StringBuilder(s1);
            }
            // System.out.println("S1: "+s1+", S2: "+s2);
            res = sb.toString();
        }
        // System.out.println(set);
        return set.pollFirst();
    }

    private String rotateString(StringBuilder sb,int b, int n){
        return sb.substring(n-b)+sb.substring(0,n-b);
    }
    private String performFirstOperation(StringBuilder sb,int a, int n){
        for(int i=1;i<n;i+=2){
            int temp = ((sb.charAt(i)-'0')+a)%10;
            sb.setCharAt(i, (char)(temp+'0'));
        }
        return sb.toString();
    }
    private boolean compare(String s1, String s2, int n){
        for(int i = 0;i<n;i++){
            if(s1.charAt(i)>s2.charAt(i)){
                return true;
            }else if (s1.charAt(i)<s2.charAt(i)){
                return false;
            }
        }
        return true;
    }
}
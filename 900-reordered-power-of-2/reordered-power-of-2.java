class Solution {
    public boolean reorderedPowerOf2(int n) {
        Set<String> set = new HashSet<>();
        int curr = 2;
        for(int i=0;i<=32;i++){
            char[] s = String.valueOf((int)Math.pow(2,i)).toCharArray();
            // System.out.println(Math.pow(2,i));

            Arrays.sort(s);
            set.add(new String(s));
        }
        // System.out.println(set);
        char[] nArr = String.valueOf(n).toCharArray();
        Arrays.sort(nArr);
        return set.contains((new String(nArr)));
    }
}
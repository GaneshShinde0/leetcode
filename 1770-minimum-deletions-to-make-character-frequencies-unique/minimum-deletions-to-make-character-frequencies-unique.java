class Solution {
    public int minDeletions(String s) {
        int count = 0;
        int[] freq = new int[26];
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }
        // Arrays.sort(freq);
        Set<Integer> set = new HashSet<>();
        for(int i:freq){
            int temp =i;
            while(set.contains(i) && i>0){
                i--;
            }
            set.add(i);
            count +=(temp-i);
            // System.out.println(set);
        }
        return count;
    }
}
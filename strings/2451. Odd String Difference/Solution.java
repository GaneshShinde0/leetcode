class Solution {
    public String oddStringMine(String[] words) {
        int m = words.length;
        int n = words[0].length();
        int[][] diffArrays = new int[m][n];
        Map<String, Integer> stringToIndex= new HashMap<>();
        Map<String, Integer> stringToFreq= new HashMap<>();

        for(int i=0;i<m;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<=n-2;j++){
                sb.append(words[i].charAt(j+1)-words[i].charAt(j));
            }
            stringToFreq.put(sb.toString(),stringToFreq.getOrDefault(sb.toString(),0)+1);
            stringToIndex.put(sb.toString(),i);
        }
        for(Map.Entry<String, Integer> entry: stringToFreq.entrySet()){
            if(entry.getValue()==1) return words[stringToIndex.get(entry.getKey())];
        }
        return words[m-1];
    }
    public String oddString(String[] words) {
        int matchesFirst = 0;
        int mismatchIdx = -1;
        for (int i = 1; i < words.length; i++) {
            if (matchesDiff(words[0], words[i])) {
                matchesFirst++;
            } else {
                mismatchIdx = i;
            }
        }
        if (matchesFirst == 0) {
            return words[0];
        }
        return words[mismatchIdx];
    }

    private static boolean matchesDiff(String a, String b) {
        for (int i = 0; i < a.length() - 1; i++) {
            if (a.charAt(i + 1) - a.charAt(i) != b.charAt(i + 1) - b.charAt(i)) {
                return false;
            }
        }
        return true;
    }

}

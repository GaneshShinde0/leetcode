class Solution {
    public List<String> findAndReplacePatternDoesNotWork(String[] words, String pattern) {
        HashMap<String,int[]> hm = new HashMap<>();
        List<String> li = new ArrayList<>();
        int[] src = new int[26];
        for(char c:pattern.toCharArray()){
            src[c-'a']++;
        }
        Arrays.sort(src);
        for(String s:words){
            int[] freqT = new int[26];
            for(char c:s.toCharArray()){
                freqT[c-'a']++;
            }
            if(isFreqSame(freqT,src)) li.add(s);
        }
        return li;
    }
    private boolean isFreqSame(int[] src, int[] tgt){
        Arrays.sort(src);
        return Arrays.equals(src,tgt);
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> li = new ArrayList<>();
        HashMap<Character,Character> hm = new HashMap<>();
        StringBuilder pat = new StringBuilder();
        int start = 0;
        for(int i=0;i<pattern.length();i++){
            if(!hm.containsKey(pattern.charAt(i))){
                hm.put(pattern.charAt(i),(char)(start+'a'));
                start++;
            }
            pat.append(hm.get(pattern.charAt(i)));
        }
        System.out.println(pat.toString());

        for(String s: words){
            StringBuilder sb = new StringBuilder();
            start = 0;
            hm = new HashMap<>();
            for(int i=0;i<pattern.length();i++){
                if(!hm.containsKey(s.charAt(i))){
                    hm.put(s.charAt(i),(char)(start+'a'));
                    start++;
                }
                sb.append(hm.get(s.charAt(i)));
            }
            System.out.println(hm);
            if(sb.toString().equals(pat.toString())) li.add(s);
        }
        int[] src = new int[26];
        
        return li;
    }
    

}
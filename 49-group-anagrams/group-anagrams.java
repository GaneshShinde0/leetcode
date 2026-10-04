class Solution {
    public List<List<String>> groupAnagramsInitial(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, Integer> hm = new HashMap<>();
        int curr = 0;
        for(String s: strs){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String sortedString = new String(ch);
            int temp = hm.getOrDefault(sortedString,curr);
            if(temp>=res.size()){
                res.add(new ArrayList<>());
                res.get(curr).add(s);
                hm.put(sortedString,temp);
                curr++;
            }else{
                res.get(temp).add(s);
            }
        }
        return res;
    }
    
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<>();
        for(String s:strs){
            int[] freq = freq(s);
            String key = Arrays.toString(freq);
            hm.computeIfAbsent(key, x->new ArrayList<String>()).add(s);
        }
        return new ArrayList<>(hm.values());
    }
    int[] freq(String s){
        int[] freq = new int[26];
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }
        return freq;
    }
}
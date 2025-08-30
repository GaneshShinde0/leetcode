class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, Integer> hm = new HashMap<>();
        int curr = 0;
        for(String s: strs){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String tempS = new String(ch);
            int temp = hm.getOrDefault(tempS,curr);
            if(temp>=res.size()){
                res.add(new ArrayList<>());
                res.get(curr).add(s);
                hm.put(tempS,temp);
                curr++;
            }else{
                res.get(temp).add(s);
            }
        }
        System.out.println(hm);
        return res;
    }
}
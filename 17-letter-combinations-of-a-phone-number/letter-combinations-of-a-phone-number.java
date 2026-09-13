class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if(digits == null || digits.length() == 0) return res;
        Map<Integer,String> mp = new HashMap<>();
        mp.put(1,"");
        mp.put(2,"abc");
        mp.put(3,"def");
        mp.put(4,"ghi");
        mp.put(5,"jkl");
        mp.put(6,"mno");
        mp.put(7,"pqrs");
        mp.put(8,"tuv");
        mp.put(9,"wxyz");
        solve(digits, 0, res, mp,"");
        return res;
    }

    private void solve(String digits, int index, List<String> res, Map<Integer, String> map, String pref){
        if(index ==digits.length()){
            res.add(pref);
            return;
        }
        System.out.println(digits.charAt(index));
        String letters = map.get(digits.charAt(index)-'0');
        for(int i=0;i<letters.length();i++){
            String newString = pref+letters.charAt(i);
            solve(digits, index+1, res, map, newString);
        }
    }
}
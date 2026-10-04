class Solution {
    public boolean isIsomorphicNaive(String t, String s) {
        if(s.length()!=t.length()) return false;
        Map<Character,Character> map = new HashMap<>();
        Map<Character,Character> mapRev = new HashMap<>();

        char[] schars= s.toCharArray();
        char[] tchars = t.toCharArray();

        for(int i=0;i<t.length();i++){
            if(map.get(tchars[i])==null){
                map.put(tchars[i],schars[i]);
            }
            if(schars[i]!=map.get(tchars[i])){
                return false;
            }

            if(mapRev.get(schars[i])==null){
                mapRev.put(schars[i],tchars[i]);
            }
            if(tchars[i]!=mapRev.get(schars[i])){
                return false;
            }
        }
        return true;
    }

    public boolean isIsomorphicSlowerThanNaive(String s, String t) {
        if (s.length() != t.length()) return false;
        
        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> mapRev = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            
            // Check s -> t mapping
            if (map.getOrDefault(sc, tc) != tc) return false;
            map.putIfAbsent(sc, tc);
            
            // Check t -> s mapping
            if (mapRev.getOrDefault(tc, sc) != sc) return false;
            mapRev.putIfAbsent(tc, sc);
        }
        
        return true;
    }

    public boolean isIsomorphicNaive2(String s, String t) {
        if (s.length() != t.length()) return false;
        
        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> mapRev = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            
            // Check if s -> t mapping is consistent
            if (map.containsKey(sc)) {
                if (map.get(sc) != tc) return false;
            } else {
                map.put(sc, tc);
            }
            
            // Check if t -> s mapping is consistent
            if (mapRev.containsKey(tc)) {
                if (mapRev.get(tc) != sc) return false;
            } else {
                mapRev.put(tc, sc);
            }
        }
        
        return true;
    }

    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()) return false;
        Map<Character,Character> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                if(map.get(s.charAt(i))!=t.charAt(i)){
                    return false;
                }
            }else{
                if(map.containsValue(t.charAt(i))) return false;
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }
}
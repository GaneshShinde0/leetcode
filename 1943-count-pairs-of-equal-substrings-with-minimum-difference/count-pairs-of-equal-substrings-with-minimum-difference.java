class Solution {
    public int countQuadruples(String f, String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < f.length(); i++)
            map.putIfAbsent(f.charAt(i), i); //we only care about the first appearance of each letter

        int ans = 0;
        for (int i = s.length() - 1, min = Integer.MAX_VALUE; i >= 0 && min >= -i; i--){
            if (!map.containsKey(s.charAt(i))) continue; //we can terminate when min < -i because -i is the minimum that min can go 
            if (map.get(s.charAt(i)) - i < min){ans = 1; min = map.get(s.charAt(i)) - i;}
            else if (map.get(s.charAt(i)) - i == min) ans++;
        }

        return ans;
    }
}
/*
Numbers should be
25 
50
75
00
*/

class Solution {
    public int minimumOperations(String num) {
        int n = num.length();
        int i = n-1;
        HashMap<Integer,Integer> hm = new HashMap<>();
        while(i>=0){
            int curr = num.charAt(i)-'0';
            if(hm.containsKey(0) && (curr==0 ||curr==5)){
                return n-i-2;
            }else if(hm.containsKey(5) && (curr==2||curr==7)){
                return n-i-2;
            }
            hm.put(curr, hm.getOrDefault(curr,0)+1);
            i--;
        }
        if(hm.containsKey(0)) return n-hm.get(0);
        return num.length();
    }
}
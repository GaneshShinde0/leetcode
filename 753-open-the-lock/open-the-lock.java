/*
There would be 1000 Combinations, 
Time complexity will become O(10000)

Memory Complexity:
Worst Case O(10000)
*/

class Solution {
    static class Pair{
        String digits;
        int turns;
        Pair(String digits, int turns){
            this.digits = digits;
            this.turns = turns;
        }
    }
    public int openLock(String[] deadends, String target) {
        Set<String> deadEnds = new HashSet<>();
        Set<String> visited = new HashSet<>();
        for(String s:deadends) visited.add(s);
        if(visited.contains("0000")) return -1;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair("0000",0));

        while(!queue.isEmpty()){
            Pair p = queue.poll();
            if(p.digits.equals(target)) return p.turns;                        
            int turns = p.turns;
            List<String> childrens = getChildrens(p.digits,visited);
            for(String c:childrens){
                if(visited.contains(c)) continue;
                visited.add(c);
                queue.add(new Pair(c,turns+1));
            }
        }
        return -1;
    }
    private List<String> getChildrens(String s, Set<String> visited){
        List<String> childrens = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            int plus = ((s.charAt(i)-'0')+1)%10;
            int minus = ((s.charAt(i)-'0'+10)-1)%10;
            String plusCombination = s.substring(0,i)+(plus)+s.substring(i+1);
            String minusCombination = s.substring(0,i)+(minus)+s.substring(i+1);
            if(!visited.contains(plusCombination)) childrens.add(plusCombination);
            if(!visited.contains(minusCombination)) childrens.add(minusCombination);
        }
        return childrens;
    }

}
class Solution {
    private Set<Integer> seen = new HashSet<>();
    private int jug1Cap, jug2Cap, target;
    public boolean canMeasureWater(int jug1, int jug2, int target) {
        this.jug1Cap = jug1;
        this.jug2Cap = jug2;
        this.target = target;
        return dfs(0,0);
    }
    private boolean dfs(int jug1,int jug2){
        int key = jug1*1000000+jug2;
        if(seen.contains(key)) return false;
        seen.add(key);
        // If anything matches target
        if(target==jug1||target==jug2||(jug1+jug2)==target) return true;

        if(dfs(jug1Cap,jug2)) return true;
        if(dfs(jug1,jug2Cap)) return true;
        if(dfs(0,jug2)) return true;
        if(dfs(jug1,0)) return true;

        // Pour from jug1 to jug2 as much as possible.
        int pour1To2 = Math.min(jug1,jug2Cap-jug2);
        if(dfs(jug1-pour1To2,jug2+pour1To2)) return true;

        // Pour from Jug 2 to Jug1 as much as possible.
        int pour2To1 = Math.min(jug2,jug1Cap-jug1);
        return dfs(jug1+pour2To1, jug2-pour2To1);
    }
}
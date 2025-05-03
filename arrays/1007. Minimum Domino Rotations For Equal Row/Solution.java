class Solution {
    public int minDominoRotationsInitial(int[] tops, int[] bottoms) {
        int res = getRotation(tops, bottoms, tops[0]);
        if(bottoms[0]!=tops[0]){
            res = Math.min(res, getRotation(tops, bottoms, bottoms[0]));
        }
        return res == Integer.MAX_VALUE?-1:res;
    }
    private int getRotation(int[] tops, int[] bottoms, int target){
        int rotateTop = 0, rotateBottom = 0;
        for(int i=0;i<tops.length; i++){
            if(tops[i]!=target && bottoms[i]!=target){
                return Integer.MAX_VALUE;
            }
            if(tops[i]!=target) rotateTop++;
            if(bottoms[i]!=target) rotateBottom++;
        }
        return Math.min(rotateTop, rotateBottom);
    }

    public int minDominoRotations(int[] tops, int[] bottoms){
        int n = tops.length, res = Integer.MAX_VALUE;
        int[] face = new int[7];
        for(int i = 0; i<n ; i++){
            face[tops[i]]++;
            if(bottoms[i]!=tops[i]) face[bottoms[i]]++;
        }
        for(int x = 1; x<=6; x++){
            if(face[x]<n) continue;
            int maintainTop = 0, maintainBottom = 0;
            boolean possible = true;
            for(int i=0; i<n; i++){
                if(tops[i]!=x && bottoms[i]!=x){
                    possible = false;
                    break;
                }
                if(tops[i]!=x) maintainTop++;
                if(bottoms[i]!=x)maintainBottom++;
            }
            if(possible) res = Math.min(res, Math.min(maintainTop, maintainBottom));
        }
        return res == Integer.MAX_VALUE?-1:res;
    }
}

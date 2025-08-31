class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        int[] res = new int[friends.length];
        int curr = 0;
        boolean[] friendsIdx = new boolean[101];
        for(int i:friends){
            friendsIdx[i] = true;
        }
        for(int i=0;i<order.length;i++){
            if(friendsIdx[order[i]]==true){
                res[curr]=order[i];
                curr++;
            }
        }
        return res;
    }
}
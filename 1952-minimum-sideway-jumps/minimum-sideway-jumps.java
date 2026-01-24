/*

Starting at l2=? l2=0;
if wants to go to l1 or l3 then l1=1, l3=1;
If Obstacle is there then infinite distance;

To travel to any lane at any poinnt it will be minimum of that lane and minimum of oter two lanes +1
*/

class Solution {
    public int minSideJumps(int[] obstacles) {
        int l1 = 1, l2 = 0, l3 = 1;
        for(int i:obstacles){
            if(i==1){
                l1 = 1000000;
            }
            if(i==2){
                l2 = 1000000;
            }
            if(i==3){
                l3 = 1000000;
            }
            int temp1 = l1, temp2=l2, temp3 = l3;
            if(i!=1) l1 = Math.min(Math.min(l3+1,l2+1),l1);
            if(i!=2) l2 = Math.min(Math.min(l3+1,temp1+1),l2);
            if(i!=3) l3 = Math.min(Math.min(temp1+1,temp2+1),l3);
        }
        return Math.min(l1,Math.min(l2,l3));
    }
}
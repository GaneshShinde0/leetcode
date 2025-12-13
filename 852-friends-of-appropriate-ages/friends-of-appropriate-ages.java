class Solution {
    public int numFriendRequests(int[] ages) {
        int[] count=new int[121];
        for(int i=0;i<ages.length;i++){
            count[ages[i]]++;
        }
        int result=0;
        for(int x=1;x<=120;x++){
            for(int y=1;y<=120;y++){
                if(!((y<=(0.5*x+7))||(y>x)||(y>100 && x<100))) {
                    if(x==y && count[x]>1){
                        result+=count[x]*(count[x]-1);
                        continue;
                    }else if(x==y){
                        continue;
                    }
                    result+=count[x]*count[y];
                }
            }
        }
        return result;
    }
}
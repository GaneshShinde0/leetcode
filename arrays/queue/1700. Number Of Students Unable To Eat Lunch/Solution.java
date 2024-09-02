class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int a=0,b=0;
        for(int i:students){
            if(i==0) a++;
            else b++;
        }
        for(int s:sandwiches){
            if(s==0&&a>0){
                a--;
                continue;
            }   
            if(s==1&&b>0){
                b--;
                continue;
            }
            return a+b;
        }
        return a+b;
    }
}

class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum=0;
        for(int i:chalk){
            sum+=i;
        }
        k=(int) (k%sum);
        int i=0;
        while(k>=chalk[i]){
            k-=chalk[i];
            i++;
        }
        return i;
    }

    // public int chalkReplacer(int[] chalk, int k) {
    //     int sum=0;
    //     for(int i=0;i<chalk.length;i++){
    //         // you know, maybe the chalks are not enough to go for one round
    //         k-=chalk[i];
    //         if(k<0){
    //             return i;
    //         }
    //         sum+=chalk[i];
    //     }
    //     k%=sum;
    //     for(int i=0;i<chalk.length;i++){
    //         k-=chalk[i];
    //         if(k<0){
    //             return i;
    //         }
    //     }
    //     return -1;
    // }
}
